package com.example.demo.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.IdiomaDTO;
import com.example.demo.DTO.PersonalDTO;
import com.example.demo.Entity.Colegio;
import com.example.demo.Entity.Financiamiento;
import com.example.demo.Entity.Formacion;
import com.example.demo.Entity.Funcion;
import com.example.demo.Entity.PersonaIdioma;
import com.example.demo.Entity.Personal;
import com.example.demo.Entity.Rol;
import com.example.demo.Entity.User;
import com.example.demo.Respository.PersonalRepository;
import com.example.demo.Serializable.PersonaIdiomaId;
import com.example.demo.Service.ColegioService;
import com.example.demo.Service.FinanciamientoService;
import com.example.demo.Service.FormacionService;
import com.example.demo.Service.FuncionService;
import com.example.demo.Service.IdiomaService;
import com.example.demo.Service.PersonaIdiomaService;
import com.example.demo.Service.PersonalService;
import com.example.demo.Service.RolService;
import com.example.demo.Service.UserService;

import jakarta.transaction.Transactional;

@Service
public class PersonalImpl implements PersonalService{

    @Autowired
    PersonalRepository r;

    // @Autowired
    // PersonalService service;

    @Autowired
    ColegioService colegioService;

    @Autowired
    FinanciamientoService financiamientoService;

    @Autowired
    FuncionService funcionService;

    @Autowired
    FormacionService formacionService;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    PersonaIdiomaService personaIdiomaService;

    @Autowired
    IdiomaService idiomaService;

    @Override
    public List<Personal> findAll() {
        return r.findAll();
    }

    @Override
    public Personal findById(Integer id) {
        return r.findById(id).orElseThrow();
    }

    @Override
    public Personal save(Personal x) {
        return r.save(x);
    }

    @Override
    public void deleteById(Integer id) {
        r.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return r.existsById(id);
    }

    @Transactional
    @Override
    public ResponseEntity<?> saveTransaccion(PersonalDTO x) {
        if (this.existsById(x.getCarnet())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El carnet ya existe");
        }

        // Lista de errores
        List<String> errores = new ArrayList<>();

        // Obtener entidades relacionadas y verificar existencia
        Financiamiento financiamientoOpt = financiamientoService.findById(x.getIdFinanciamiento());
        if (financiamientoOpt == null) {
            errores.add("ID financiamiento not found");
        }
        Formacion formacionOpt = formacionService.findById(x.getIdFormacion());
        if (formacionOpt == null) {
            errores.add("ID formacion not found");
        }
        Funcion funcionOpt = funcionService.findById(x.getIdFuncion());
        if (funcionOpt == null) {
            errores.add("ID funcion not found");
        }
        Colegio colegioOpt = colegioService.findById(x.getCodigoColegio());
        if (colegioOpt == null) {
            errores.add("ID colegio not found");
        }
        Optional<Rol> rolOpt = rolService.findById(x.getIdRol());
        if (rolOpt.isEmpty()){
            errores.add("ID rol not found");           
        }

        if (userService.existsByUsername(x.getCorreo())){
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED ).body("ya existe ese usuario");
        }

        // Si hay errores, devolver lista de errores
        if (!errores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errores);
        }

        // Crear la entidad `Personal` y asignar valores
        Personal per = new Personal();
        per.setCarnet(x.getCarnet());
        per.setApellidoMaterno(x.getApellidoMaterno());
        per.setApellidoPaterno(x.getApellidoPaterno());
        per.setBraile(x.getBraile());
        per.setComplemento(x.getComplemento());
        per.setCorreo(x.getCorreo());
        per.setDenominativo(x.getDenominativo());
        per.setDireccionDomiciliaria(x.getDireccionDomiciliaria());
        per.setExtranjero(x.getExtranjero());
        per.setFechaNacimiento(x.getFechaNacimiento());
        per.setGenero(x.getGenero());
        per.setNombres(x.getNombres());
        per.setNormalista(x.getNormalista());
        per.setNroCelular(x.getNroCelular());
        per.setNroItem(x.getNroItem());
        per.setRda(x.getRda());
        
        per.setFinanciamiento(financiamientoOpt);
        per.setFormacion(formacionOpt);
        per.setFuncion(funcionOpt);
        per.setColegio(colegioOpt);

        // Crear el usuario y guardar
        User newUser = new User();
        newUser.setUsername(x.getCorreo());
        newUser.setPassword(x.getCarnet().toString());
        
        
        newUser.setRol(rolOpt.get());
        userService.register(newUser);
        
        // Guardar el registro `Personal`
        this.save(per);


        List<IdiomaDTO> idiomas = x.getIdiomas();
        PersonaIdiomaId piId = new PersonaIdiomaId();
        for (IdiomaDTO idiomaDTO : idiomas){
            piId.setIdPersonal(per.getCarnet());
            piId.setIdIdioma(idiomaDTO.getIdIdioma());
            PersonaIdioma personaIdioma = new PersonaIdioma();
            personaIdioma.setId(piId);
            personaIdioma.setEstadoEscribe(idiomaDTO.getEstadoEscribe());
            personaIdioma.setEstadoHabla(idiomaDTO.getEstadoHabla());
            personaIdioma.setEstadoLee(idiomaDTO.getEstadoLee());

            personaIdioma.setPersonal(this.findById(per.getCarnet()));
            personaIdioma.setIdioma(idiomaService.findById(idiomaDTO.getIdIdioma()));

            personaIdiomaService.save(personaIdioma);
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(per);
    }


}
