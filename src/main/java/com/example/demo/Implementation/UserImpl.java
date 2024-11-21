package com.example.demo.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Respository.UserRepository;
import com.example.demo.Service.JwtService;
import com.example.demo.Service.UserService;


@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired 
    private JwtService jwtService;



    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return  userRepository.findById(id).orElseThrow();
    }
    @Override
    public String register(User user) {
        User nuevo = new User();
        nuevo.setUsername(user.getUsername());
        nuevo.setPassword(this.passwordEncoder.encode(user.getPassword()));
        nuevo.setRol(user.getRol());
        userRepository.save(nuevo);
        return user.getUsername();
    }
    
    @Override   
    public User save (User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse loginUsuario(User user) {
        LoginResponse res = new LoginResponse();
        User employee1 = userRepository.findByUsername(user.getUsername());



        if (employee1 != null) {
            String password = user.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                
                Optional<User> employee = userRepository.findOneByUsernameAndPassword(user.getUsername(),encodedPassword);
                if (employee.isPresent()) {
                    String token = jwtService.generateToken(user.getUsername());
                    res.setMessage("Credenciales correctas");
                    res.setStatus(true);
                    res.setUsername(employee1.getUsername());
                    res.setToken(token);
                    res.setUserId(employee1.getId());
                    return res;
                } else {

                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("Login Failed", false);

            }
        } else {
            // return res;
            return new LoginResponse("Login Failed", false);

        }
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByRolId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean existsByUsername(String usernmae) {
        return userRepository.existsByUsername(usernmae);
    }

    

}
