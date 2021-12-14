package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Usuario;
import com.josefco.accesoadatosaa.exception.UsuarioNoEncontradoException;
import com.josefco.accesoadatosaa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuario(int id) throws UsuarioNoEncontradoException {
        return usuarioRepository.findById(id).orElseThrow(UsuarioNoEncontradoException::new);
    }

    @Override
    public Usuario addUsuario(Usuario Usuario) {
        return usuarioRepository.save(Usuario);
    }

    @Override
    public Usuario deleteUsuario(int id) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(UsuarioNoEncontradoException::new);
        usuarioRepository.delete(usuario);
        return usuario;
    }

    @Override
    public Usuario modifyUsuario(int id, Usuario newUsuario) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(UsuarioNoEncontradoException::new);

        usuario.setNombre(newUsuario.getNombre());
        usuario.setApellido(newUsuario.getApellido());
        usuario.setTelefono(newUsuario.getTelefono());
        usuario.setDireccion(newUsuario.getDireccion());

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findUsuariosByDireccion(String direccion) throws UsuarioNoEncontradoException {
            return usuarioRepository.findUsuariosByDireccion(direccion);
    }

}
