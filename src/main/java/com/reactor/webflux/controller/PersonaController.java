package com.reactor.webflux.controller;


import com.reactor.webflux.model.Persona;
import com.reactor.webflux.repository.IPersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private IPersonaRepository personaRepository;

    @GetMapping
    public Flux<Persona> getPersonas(){
        return personaRepository.listAll();
    }

    @GetMapping("/{id}")
    private Mono<Persona> getPersona(@PathVariable("id")Long id){
        System.out.println("Entrando en getPersona: "+id);
        return personaRepository.getById(id);
    }

    @PostMapping
    public Mono<Persona> savePersona(@RequestBody  Persona persona){
        return personaRepository.save(persona);
    }

    @PutMapping
    public Mono<Persona> updatePersona(@RequestBody Persona persona){
        return personaRepository.update(persona);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable("id") Long id){
        return personaRepository.eliminar(id);
    }


}
