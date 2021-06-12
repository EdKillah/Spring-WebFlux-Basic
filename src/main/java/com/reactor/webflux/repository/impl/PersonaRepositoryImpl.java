package com.reactor.webflux.repository.impl;

import com.reactor.webflux.controller.PersonaController;
import com.reactor.webflux.model.Persona;
import com.reactor.webflux.repository.IPersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {

    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Override
    public Mono<Persona> save(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Mono<Persona> update(Persona persona) {
        log.info("Actualizando persona: "+persona);
        return Mono.just(persona);
    }

    @Override
    public Flux<Persona> listAll() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1L, "Eduard"));
        personas.add(new Persona(2L, "Felipe"));
        personas.add(new Persona(3L, "Cesardo"));
        Flux<Persona> fluxPersonas = Flux.fromIterable(personas)
                .doOnNext(p -> log.info(p.toString()));
        System.out.println("PERSONAS FLUX: "+fluxPersonas);
        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> getById(Long id) {
        log.info("Obteniendo usuario con id {}", id);
        return Mono.just(new Persona(id, "Anonimo"));
    }

    @Override
    public Mono<Void> eliminar(Long id) {
        return Mono.empty();
    }
}
