package com.reactor.webflux.repository;

import com.reactor.webflux.model.Persona;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPersonaRepository {

    Mono<Persona> save(Persona persona);
    Mono<Persona> update(Persona persona);
    Flux<Persona> listAll();
    Mono<Persona> getById(Long id);
    Mono<Void> eliminar(Long id);
}
