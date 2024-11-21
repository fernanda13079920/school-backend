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

import com.example.demo.DTO.EspacioDTO;
import com.example.demo.Entity.Espacio;
import com.example.demo.Service.ColegioService;
import com.example.demo.Service.EspacioService;

@CrossOrigin
@RestController
@RequestMapping("api/espacio")
public class EspacioController {

    @Autowired
    EspacioService service;

    @Autowired
    ColegioService colegioS;

    @GetMapping
    public ResponseEntity<List<Espacio>> get() {
        List<Espacio> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getEntity(@PathVariable Long id) {
    //     if (!service.existById(id)) {  
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
    //     }
    //     Espacio registro = service.findById(id).get();
    //     return ResponseEntity.ok(registro);
    // }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.existById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
        service.deleteById(id);
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveRegistro(@RequestBody EspacioDTO x) {
        if (x.getCodColegio() != null) {
            if (!colegioS.existsById(x.getCodColegio())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID colegio not found");
            }
        }

        return ResponseEntity.ok(service.save(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Espacio> update(@PathVariable Long id, @RequestBody EspacioDTO x) {
        if (!service.existById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Espacio e = service.Actualizar(id, x);
        return ResponseEntity.ok(e);
    }
}
