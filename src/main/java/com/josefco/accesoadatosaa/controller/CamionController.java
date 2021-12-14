package com.josefco.accesoadatosaa.controller;


import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.service.CamionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CamionController {

    private final Logger logger = LoggerFactory.getLogger(CamionController.class);

    @Autowired
    private CamionService camionService;

    @GetMapping("/camiones")
    public List<Camion> findAllCamiones() {
        logger.info("begin findAllCamiones");
        List<Camion> camiones;
        camiones = camionService.findAllCamiones();
        logger.info("End findAllCamiones");
        return camiones;
    }

    @GetMapping("/camion/{id}")
    public Camion findCamion(@PathVariable int id) throws CamionNoEncontradoException {
        logger.info("begin findCamion by id " + id);
        Camion Camion = camionService.findCamion(id);
        logger.info("end findCamion by id" + id);
        return Camion;
    }

    @DeleteMapping("/camion/{id}")
    public Camion removeCamion(@PathVariable int id) throws CamionNoEncontradoException {
        logger.info("begin removeCamion by id " + id);
        Camion Camion = camionService.deleteCamion(id);
        logger.info("end removeCamion by id " + id);
        return Camion;
    }

    @PutMapping("/camion/{id}")
    public Camion modifyCamion(@RequestBody Camion Camion, @PathVariable int id) throws CamionNoEncontradoException {
        logger.info("begin modifyCamion by id " + id);
        Camion newCamion = camionService.modifyCamion(id, Camion);
        logger.info("end modifyCamion by id " + id);
        return newCamion;
    }

    @PostMapping("/camiones")
    public Camion saveCamion(@RequestBody Camion camion) {
        logger.info("begin saveCamion");
        Camion newCamion = camionService.saveCamion(camion);
        logger.info("end saveCamion");
        return newCamion;
    }

    @RequestMapping(value = "/camiones/marca/{marca}")
    public List<Camion> findCamionesByMarca(@PathVariable String marca) throws CamionNoEncontradoException {
        logger.info("begin findCamionesByMarca");
        List<Camion> camiones = camionService.findCamionesByMarca(marca);
        logger.info("end findCamionesByMarca");
        return camiones;
    }



    @ExceptionHandler(CamionNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handleCamionNoEncontradoException(CamionNoEncontradoException cnee) {
        RespuestaError errorResponse = new RespuestaError("1", cnee.getMessage());
        logger.info(cnee.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
