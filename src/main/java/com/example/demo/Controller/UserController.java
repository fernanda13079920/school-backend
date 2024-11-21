package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.UserService;


@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> get() {
        List<User> lista = userService.findAll();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User x) {
        User editad = userService.findById(id);
        User e = userService.save(editad);

        return ResponseEntity.ok(e);
    }

    @PostMapping(path = "/save")
    public String saveUsuario(@RequestBody User user) {
        String username = userService.register(user);
        return username;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUsuario(@RequestBody User user) {
        LoginResponse loginMessage = userService.loginUsuario(user);
        return ResponseEntity.ok(loginMessage);
    }
}