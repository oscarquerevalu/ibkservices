package com.ibk.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibk.services.model.Usuario;
import com.ibk.services.repository.UsuarioRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public Iterable<Usuario> findAll() {
        return repository.findAll();
    }
    
    @GetMapping(path = "/{id}")
    public Usuario find(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Usuario creacliente(@RequestBody Usuario user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Usuario update(@PathVariable("id") Long id, @RequestBody Usuario user) throws BadHttpRequest {
        if (repository.exists(id)) {
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }
}