package com.josefco.accesoadatosaa.controller;

import com.josefco.accesoadatosaa.domain.Usuario;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.exception.UsuarioNoEncontradoException;
import com.josefco.accesoadatosaa.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final Logger logger = LoggerFactory.getLogger(PaqueteController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> findAllUsuarios() {
        logger.info("begin findAllUsuarios");
        List<Usuario> usuarios;
        usuarios =  usuarioService.findAllUsuarios();
        logger.info("end findAllUsuarios");
        return usuarios;
    }

    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id) throws UsuarioNoEncontradoException {
        logger.info("begin getUsuario");
        Usuario Usuario = usuarioService.findUsuario(id);
        logger.info("end getUsuario");
        return Usuario;
    }

    @DeleteMapping("/usuario/{id}")
    public Usuario removeUsuario(@PathVariable int id) throws UsuarioNoEncontradoException {
        logger.info("begin removeUsuario");
        Usuario Usuario = usuarioService.deleteUsuario(id);
        logger.info("end removeUsuario");
        return Usuario;
    }

    @PostMapping("/usuarios")
    public Usuario addUsuario(@RequestBody Usuario Usuario) {
        logger.info("begin addUsuario");
        Usuario newUsuario = usuarioService.addUsuario(Usuario);
        logger.info("end addUsuario");
        return newUsuario;
    }

    @PutMapping("/usuario/{id}")
    public Usuario modifyUsuario(@RequestBody Usuario Usuario, @PathVariable int id) throws UsuarioNoEncontradoException {
        logger.info("begin modifyUsuario");
        Usuario newUsuario = usuarioService.modifyUsuario(id, Usuario);
        logger.info("end modifyUsuario");
        return newUsuario;
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleUsuarioNoEncontradoException(UsuarioNoEncontradoException unee) {
        RespuestaError errorResponse = new RespuestaError("1", unee.getMessage());
        logger.info(unee.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
