package com.josefco.accesoadatosaa.controller;

import com.josefco.accesoadatosaa.domain.Conductor;
import com.josefco.accesoadatosaa.exception.ConductorNoEncontradoException;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.service.ConductorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConductorController {

    private final Logger logger = LoggerFactory.getLogger(ConductorController.class);

    @Autowired
    private ConductorService conductorService;

    @GetMapping("/conductores")
    public List<Conductor> findAllConductores() {
        logger.info("begin findAllConductores");
        List<Conductor> conductores;
        conductores = conductorService.findAllConductores();
        logger.info("end findAllConductores");
        return conductores;
    }

    @GetMapping("/conductor/{id}")
    public Conductor findConductor(@PathVariable int id) throws ConductorNoEncontradoException {
        logger.info("begin findConductor by id: "+id);
        Conductor conductor = conductorService.findConductor(id);
        logger.info("end findConductor by id: "+id);
        return conductor;
    }

    @DeleteMapping("/conductor/{id}")
    public Conductor removeConductor(@PathVariable int id) throws ConductorNoEncontradoException {
        logger.info("begin removeConductor by id: "+id);
        Conductor Conductor = conductorService.deleteConductor(id);
        logger.info("end removeConductor by id: "+id);
        return Conductor;
    }

    @PostMapping("/conductores")
    public Conductor saveCondutor(@RequestBody Conductor conductor) {
        logger.info("begin saveCondutor");
        Conductor newConductor = conductorService.saveConductor(conductor);
        logger.info("begin saveCondutor");
        return newConductor;
    }

    @PutMapping("/conductor/{id}")
    public Conductor modifyConductor(@RequestBody Conductor Conductor, @PathVariable int id) throws ConductorNoEncontradoException {
        logger.info("begin modifyConductor id: "+id);
        Conductor newConductor = conductorService.modifyConductor(id, Conductor);
        logger.info("begin modifyConductor id: "+ id);
        return newConductor;
    }


    @RequestMapping(value = "/conductores/direccion/{direccion}")
    public List<Conductor> findConductorByDireccion(@PathVariable String direccion) throws ConductorNoEncontradoException{
        logger.info("begin findConductorByDireccion");
        List<Conductor> conductores = conductorService.findConductorByDireccion(direccion);
        logger.info("end findConductorByDireccion");
        return conductores;
    }

    @ExceptionHandler(ConductorNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleConductorNoEncontradoException(ConductorNoEncontradoException cnee) {
        RespuestaError errorResponse = new RespuestaError("1", cnee.getMessage());
        logger.error(cnee.getMessage(), cnee);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
