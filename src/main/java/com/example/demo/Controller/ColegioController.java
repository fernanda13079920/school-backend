package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.Entity.Colegio;
import com.example.demo.Service.ColegioService;

@CrossOrigin
@RestController
@RequestMapping("api/colegio")
public class ColegioController {

    @Autowired
    private ColegioService service;

    @GetMapping
    public ResponseEntity<List<Colegio>> get() {
        List<Colegio> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colegio> getEntity(@PathVariable Integer id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }

        Colegio registro = service.findById(id); 
        return ResponseEntity.ok(registro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
        service.deleteById(id); 
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Colegio> saveRegistro(@RequestBody Colegio x) {
        return ResponseEntity.ok(service.save(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colegio> update(@PathVariable Integer id, @RequestBody Colegio x) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }

        Colegio e = service.save(x);
        return ResponseEntity.ok(e);
    }

}
