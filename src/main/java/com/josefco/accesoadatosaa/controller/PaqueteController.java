package com.josefco.accesoadatosaa.controller;

import com.josefco.accesoadatosaa.domain.PaquetDTO;
import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaqueteController {


    @Autowired
    private PaqueteService paqueteService;

    @GetMapping("/paquetes")
    public List<Paquete> findAllPaquetees() {
        return paqueteService.findAllPaquetes();
    }

    @GetMapping("/paquete/{id}")
    public Paquete findPaquete(@PathVariable int id) throws PaqueteNoEncontradoException {
        Paquete Paquete = paqueteService.findPaquete(id);
        return Paquete;
    }

    @DeleteMapping("/paquete/{id}")
    public Paquete removePaquete(@PathVariable int id) throws PaqueteNoEncontradoException {
        Paquete Paquete = paqueteService.deletePaquete(id);
        return Paquete;
    }


    @PostMapping("/paquete")
    public Paquete addPaquete(@RequestBody PaquetDTO paquetDTO) throws Exception {
        return paqueteService.addPaquete(paquetDTO);
    }

    @PutMapping("/paquete/{id}")
    public Paquete modifyPaquete(@RequestBody Paquete Paquete, @PathVariable int id) throws PaqueteNoEncontradoException {
        Paquete newPaquete = paqueteService.modifyPaquete(id, Paquete);
        return newPaquete;
    }

    @ExceptionHandler(PaqueteNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handlePaqueteNoEncontradoException(PaqueteNoEncontradoException pnee) {
        RespuestaError errorResponse = new RespuestaError("1", pnee.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
