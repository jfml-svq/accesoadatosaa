package com.josefco.accesoadatosaa.service;


import com.josefco.accesoadatosaa.domain.Usuario;
import com.josefco.accesoadatosaa.exception.UsuarioNoEncontradoException;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAllUsuarios();
    Usuario findUsuario(int id) throws UsuarioNoEncontradoException;

    Usuario addUsuario(Usuario Usuario);
    Usuario deleteUsuario(int id) throws UsuarioNoEncontradoException;
    Usuario modifyUsuario(int id, Usuario Usuario) throws UsuarioNoEncontradoException;

    List<Usuario> findUsuariosByDireccion(String direccion) throws UsuarioNoEncontradoException;

    int countUsuario();

}
