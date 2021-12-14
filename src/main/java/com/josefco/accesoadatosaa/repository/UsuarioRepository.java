package com.josefco.accesoadatosaa.repository;

import com.josefco.accesoadatosaa.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    List<Usuario> findAll();

    List<Usuario> findUsuariosByDireccion(String direccion);
    //Usuario findById(int id);
}
