package com.ibk.services.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ibk.services.model.Usuario;

//@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario")
@RestResource(exported = false)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
