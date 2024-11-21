package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Idioma;
import com.example.demo.Service.IdiomaService;

@CrossOrigin
@RestController
@RequestMapping("api/idioma")
public class IdiomaController {
    @Autowired
    IdiomaService service;

    @GetMapping
    public ResponseEntity<List<Idioma>> get() {
        List<Idioma> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }
}
