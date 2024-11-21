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

import com.example.demo.DTO.EdificioDTO;
import com.example.demo.DTOresponse.EdificioResponse;
import com.example.demo.Entity.Edificio;
import com.example.demo.Service.ColegioService;
import com.example.demo.Service.EdificioService;


@CrossOrigin
@RestController
@RequestMapping("api/edificio")
public class EdifcioController {
    @Autowired
    EdificioService service;

    @Autowired
    ColegioService colegio;

    @GetMapping
    public ResponseEntity<List<Edificio>> get() {
        List<Edificio> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntity(@PathVariable Long id) {
        if (!service.existById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }
        EdificioResponse registro = service.findByIdTotal(id);
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
    public ResponseEntity<?> saveRegistro(@RequestBody EdificioDTO x) {
        return ResponseEntity.ok(service.save(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EdificioDTO x) {
        if (!service.existById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no existe id edificio");         
        }  
        if (!colegio.existsById(x.getIdColegio())) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no existe id colegio");       
        }      
        return ResponseEntity.ok(service.Actualizar(id, x));
    }
}
