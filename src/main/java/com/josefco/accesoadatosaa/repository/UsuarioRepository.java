package com.josefco.accesoadatosaa.repository;

import com.josefco.accesoadatosaa.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findAll();
    Usuario findById(int id);
}
