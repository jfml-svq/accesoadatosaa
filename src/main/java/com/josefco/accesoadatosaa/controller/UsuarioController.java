package com.josefco.accesoadatosaa.controller;

import com.josefco.accesoadatosaa.domain.Usuario;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.exception.UsuarioNoEncontradoException;
import com.josefco.accesoadatosaa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> findAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id) throws UsuarioNoEncontradoException {
        Usuario Usuario = usuarioService.findUsuario(id);
        return Usuario;
    }

    @DeleteMapping("/usuario/{id}")
    public Usuario removeUsuario(@PathVariable int id) throws UsuarioNoEncontradoException {
        Usuario Usuario = usuarioService.deleteUsuario(id);
        return Usuario;
    }

    @PostMapping("/usuarios")
    public Usuario addUsuario(@RequestBody Usuario Usuario) {
        Usuario newUsuario = usuarioService.addUsuario(Usuario);
        return newUsuario;
    }

    @PutMapping("/usuario/{id}")
    public Usuario modifyUsuario(@RequestBody Usuario Usuario, @PathVariable int id) throws UsuarioNoEncontradoException {
        Usuario newUsuario = usuarioService.modifyUsuario(id, Usuario);
        return newUsuario;
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleUsuarioNoEncontradoException(UsuarioNoEncontradoException unee) {
        RespuestaError errorResponse = new RespuestaError("1", unee.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
