package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.User;
import com.example.demo.Response.LoginResponse;


public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User findUser(String username);

    void deleteById(Long id);

    LoginResponse loginUsuario(User user);

    String register(User user);

    boolean existsByRolId(Long id);

    boolean existsByUsername(String correo);

    

}
