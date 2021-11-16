package com.josefco.accesoadatosaa.controller;

import com.josefco.accesoadatosaa.domain.Conductor;
import com.josefco.accesoadatosaa.exception.ConductorNoEncontradoException;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping("/conductores")
    public List<Conductor> findAllConductores() {
        return conductorService.findAllConductores();
    }

    @GetMapping("/conductor/{id}")
    public Conductor findConductor(@PathVariable int id) throws ConductorNoEncontradoException {
        Conductor Conductor = conductorService.findConductor(id);
        return Conductor;
    }

    @DeleteMapping("/conductor/{id}")
    public Conductor removeConductor(@PathVariable int id) throws ConductorNoEncontradoException {
        Conductor Conductor = conductorService.deleteConductor(id);
        return Conductor;
    }

    @PostMapping("/conductores")
    public Conductor addConductor(@RequestBody Conductor Conductor) {
        Conductor newConductor = conductorService.addConductor(Conductor);
        return Conductor;
    }

    @PutMapping("/conductor/{id}")
    public Conductor modifyConductor(@RequestBody Conductor Conductor, @PathVariable int id) throws ConductorNoEncontradoException {
        Conductor newConductor = conductorService.modifyConductor(id, Conductor);
        return newConductor;
    }

    @ExceptionHandler(ConductorNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleConductorNoEncontradoException(ConductorNoEncontradoException cnee) {
        RespuestaError errorResponse = new RespuestaError("1", cnee.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
