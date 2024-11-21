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

import com.example.demo.Entity.Aula;
import com.example.demo.Service.AulaService;

@CrossOrigin
@RestController
@RequestMapping("api/aula")
public class AulaController {
    @Autowired
    AulaService service;

    @GetMapping
    public ResponseEntity<List<Aula>> get() {
        List<Aula> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntity(@PathVariable Long id) {
        if (!service.existById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");      
        }

        Aula registro = service.findById(id).get(); 
        return ResponseEntity.ok(registro);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.existById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
        service.deleteById(id); 
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveRegistro(@RequestBody Aula x) {
        if(service.existByNombre(x.getNombre())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre del aula ya existe");
        }
        
        Aula savedAula = service.save(x);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> update(@PathVariable Long id, @RequestBody Aula x) {
        if (!service.existById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }
        Aula editad = service.findById(id).get();
        editad.setNombre(x.getNombre());
        Aula e = service.save(editad);
        return ResponseEntity.ok(e);
    }
}
