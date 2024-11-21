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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PersonalDTO;
import com.example.demo.DTOresponse.IdiomaResponse;
import com.example.demo.DTOresponse.PersonalResponse;
import com.example.demo.DTOresponse.rolResponse;
import com.example.demo.Entity.Personal;
import com.example.demo.Entity.User;
import com.example.demo.Service.PersonaIdiomaService;
import com.example.demo.Service.PersonalService;
import com.example.demo.Service.RolService;
import com.example.demo.Service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/personal")
public class PersonalController {

    @Autowired
    PersonalService service;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    PersonaIdiomaService personaIdiomaService;


    @GetMapping
    public ResponseEntity<List<Personal>> get() {
        List<Personal> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResponse> getEntity(@PathVariable Integer id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }

        Personal registro = service.findById(id); 
        User user = userService.findUser(registro.getCorreo());
        rolResponse rol = rolService.obtenerRolConPermisos(user.getRol().getId());
        List<IdiomaResponse> idiomas = personaIdiomaService.obtenerListaIdioma(id);

        PersonalResponse response = new PersonalResponse();
        response.setPersonal(registro);
        response.setRol(rol);
        response.setIdiomas(idiomas);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
        Personal persona = service.findById(id);
        User user = userService.findUser(persona.getCorreo());
        
        userService.deleteById(user.getId());
        personaIdiomaService.deleteAllByCarnet(persona.getCarnet());




        service.deleteById(id); 
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveRegistro(@RequestBody PersonalDTO x) {
            
        // //Verificar si el carnet ya existe
        // if (service.existsById(x.getCarnet())) {
        //     return ResponseEntity.status(HttpStatus.CONFLICT).body("El carnet ya existe");
        // }

        // // Lista de errores
        // List<String> errores = new ArrayList<>();

        // // Obtener entidades relacionadas y verificar existencia
        // Financiamiento financiamientoOpt = financiamientoService.findById(x.getIdFinanciamiento());
        // if (financiamientoOpt == null) {
        //     errores.add("ID financiamiento not found");
        // }
        // Formacion formacionOpt = formacionService.findById(x.getIdFormacion());
        // if (formacionOpt == null) {
        //     errores.add("ID formacion not found");
        // }
        // Funcion funcionOpt = funcionService.findById(x.getIdFuncion());
        // if (funcionOpt == null) {
        //     errores.add("ID funcion not found");
        // }
        // Colegio colegioOpt = colegioService.findById(x.getCodigoColegio());
        // if (colegioOpt == null) {
        //     errores.add("ID colegio not found");
        // }
        // Optional<Rol> rolOpt = rolService.findById(x.getIdRol());
        // if (rolOpt.isEmpty()){
        //     errores.add("ID rol not found");           
        // }

        // if (userService.existsByUsername(x.getCorreo())){
        //     return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED ).body("ya existe ese usuario");
        // }

        // // Si hay errores, devolver lista de errores
        // if (!errores.isEmpty()) {
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errores);
        // }

        // // Crear la entidad `Personal` y asignar valores
        // Personal per = new Personal();
        // per.setCarnet(x.getCarnet());
        // per.setApellidoMaterno(x.getApellidoMaterno());
        // per.setApellidoPaterno(x.getApellidoPaterno());
        // per.setBraile(x.getBraile());
        // per.setComplemento(x.getComplemento());
        // per.setCorreo(x.getCorreo());
        // per.setDenominativo(x.getDenominativo());
        // per.setDireccionDomiciliaria(x.getDireccionDomiciliaria());
        // per.setExtranjero(x.getExtranjero());
        // per.setFechaNacimiento(x.getFechaNacimiento());
        // per.setGenero(x.getGenero());
        // per.setNombres(x.getNombres());
        // per.setNormalista(x.getNormalista());
        // per.setNroCelular(x.getNroCelular());
        // per.setNroItem(x.getNroItem());
        // per.setRda(x.getRda());
        
        // per.setFinanciamiento(financiamientoOpt);
        // per.setFormacion(formacionOpt);
        // per.setFuncion(funcionOpt);
        // per.setColegio(colegioOpt);

        // // Crear el usuario y guardar
        // User newUser = new User();
        // newUser.setUsername(x.getCorreo());
        // newUser.setPassword(x.getCarnet().toString());
        
        
        // newUser.setRol(rolOpt.get());
        // userService.register(newUser);
        
        // // Guardar el registro `Personal`
        // service.save(per);


        // List<IdiomaDTO> idiomas = x.getIdiomas();
        // PersonaIdiomaId piId = new PersonaIdiomaId();
        // for (IdiomaDTO idiomaDTO : idiomas){
        //     piId.setIdPersonal(per.getCarnet());
        //     piId.setIdIdioma(idiomaDTO.getIdIdioma());
        //     PersonaIdioma personaIdioma = new PersonaIdioma();
        //     personaIdioma.setId(piId);
        //     personaIdioma.setEstadoEscribe(idiomaDTO.getEstadoEscribe());
        //     personaIdioma.setEstadoHabla(idiomaDTO.getEstadoHabla());
        //     personaIdioma.setEstadoLee(idiomaDTO.getEstadoLee());

        //     personaIdioma.setPersonal(service.findById(per.getCarnet()));
        //     personaIdioma.setIdioma(idiomaService.findById(idiomaDTO.getIdIdioma()));

        //     personaIdiomaService.save(personaIdioma);
        // }

        return service.saveTransaccion(x);

    }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PersonalDTO x) {
    //    // Verificar si el registro existe
    //     if (!service.existsById(id)) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID de Personal no encontrado");
    //     }

    //     // Lista de errores
    //     List<String> errores = new ArrayList<>();

    //     // Verificar existencia de entidades relacionadas
    //     Financiamiento financiamiento = financiamientoService.findById(x.getIdFinanciamiento());
    //     if (financiamiento == null) {
    //         errores.add("ID financiamiento not found");
    //     }

    //     Formacion formacion = formacionService.findById(x.getIdFormacion());
    //     if (formacion == null) {
    //         errores.add("ID formacion not found");
    //     }

    //     Funcion funcion = funcionService.findById(x.getIdFuncion());
    //     if (funcion == null) {
    //         errores.add("ID funcion not found");
    //     }

    //     Colegio colegio = colegioService.findById(x.getCodigoColegio());
    //     if (colegio == null) {
    //         errores.add("ID colegio not found");
    //     }

    //     // Si hay errores, devolver lista de errores
    //     if (!errores.isEmpty()) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errores);
    //     }

    //     // Obtener el registro existente y actualizar sus campos
    //     Personal editado = service.findById(id);
    //     editado.setApellidoMaterno(x.getApellidoMaterno());
    //     editado.setApellidoPaterno(x.getApellidoPaterno());
    //     editado.setBraile(x.getBraile());
    //     editado.setComplemento(x.getComplemento());
    //     editado.setCorreo(x.getCorreo());
    //     editado.setDenominativo(x.getDenominativo());
    //     editado.setDireccionDomiciliaria(x.getDireccionDomiciliaria());
    //     editado.setExtranjero(x.getExtranjero());
    //     editado.setFechaNacimiento(x.getFechaNacimiento());
    //     editado.setGenero(x.getGenero());
    //     editado.setNombres(x.getNombres());
    //     editado.setNormalista(x.getNormalista());
    //     editado.setNroCelular(x.getNroCelular());
    //     editado.setNroItem(x.getNroItem());
    //     editado.setRda(x.getRda());

    //     // Asignar relaciones
    //     editado.setFinanciamiento(financiamiento);
    //     editado.setFormacion(formacion);
    //     editado.setFuncion(funcion);
    //     editado.setColegio(colegio);

    //     User user = userService.findUser(x.getCorreo());
    //     user.setUsername(editado.getCorreo());
    //     userService.save(user);

    //     // Guardar los cambios
    //     Personal actualizado = service.save(editado);

    //     return ResponseEntity.ok(actualizado);
    // }
}
