package com.josefco.accesoadatosaa.controller;


import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CamionController {

    @Autowired
    private CamionService camionService;

    @GetMapping("/camiones")
    public List<Camion> findAllCamiones() {
        return camionService.findAllCamiones();
    }

    @GetMapping("/camion/{id}")
    public Camion findCamion(@PathVariable int id) throws CamionNoEncontradoException {
        Camion Camion = camionService.findCamion(id);
        return Camion;
    }

    @DeleteMapping("/camion/{id}")
    public Camion removeCamion(@PathVariable int id) throws CamionNoEncontradoException {
        Camion Camion = camionService.deleteCamion(id);
        return Camion;
    }

    @PutMapping("/camion/{id}")
    public Camion modifyCamion(@RequestBody Camion Camion, @PathVariable int id) throws CamionNoEncontradoException {
        Camion newCamion = camionService.modifyCamion(id, Camion);
        return newCamion;
    }

    @PostMapping("/camiones")
    public Camion saveCamion(@RequestBody Camion camion) {
        Camion newCamion = camionService.saveCamion(camion);
        return newCamion;
    }

    @ExceptionHandler(CamionNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleCamionNoEncontradoException(CamionNoEncontradoException cnee) {
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
