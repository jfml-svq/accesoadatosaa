package com.josefco.accesoadatosaa.controller;

import com.josefco.accesoadatosaa.domain.dto.PaquetDTO;
import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;
import com.josefco.accesoadatosaa.exception.RespuestaError;
import com.josefco.accesoadatosaa.service.PaqueteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaqueteController {

    private final Logger logger = LoggerFactory.getLogger(PaqueteController.class);


    @Autowired
    private PaqueteService paqueteService;

    @GetMapping("/paquetes")
    public List<Paquete> findAllPaquetees() {
        logger.info("begin findAllPaquetees");
        List<Paquete> paquetes;
        paquetes = paqueteService.findAllPaquetes();
        logger.info("end findAllPaquetees");
        return paquetes;
    }

    //Filtro de un parametro
    @RequestMapping("/paquetes/color/{color}")
    public List<Paquete> findPaqueteByColor(@PathVariable String color) throws PaqueteNoEncontradoException {
        logger.info("begin findPaqueteByColor");
        List<Paquete> paquetes = paqueteService.findPaqueteByColor(color);
        logger.info("end findPaqueteByColor");
        return paquetes;
    }

    @GetMapping("/paquete/{id}")
    public Paquete findPaquete(@PathVariable int id) throws PaqueteNoEncontradoException {
        logger.info("begin findPaquete by id "+id);
        Paquete Paquete = paqueteService.findPaquete(id);
        logger.info("end findPaquete by id " + id);
        return Paquete;
    }


    @DeleteMapping("/paquete/{id}")
    public Paquete removePaquete(@PathVariable int id) throws PaqueteNoEncontradoException {
        logger.info("begin removePaquete by id "+ id);
        Paquete Paquete = paqueteService.deletePaquete(id);
        logger.info("end removePaquete by id "+ id);
        return Paquete;
    }



    @PostMapping("/paquete")
    public Paquete addPaquete(@RequestBody PaquetDTO paquetDTO) throws Exception {
        logger.info("begin addPaquete");
        Paquete paquete = paqueteService.addPaquete(paquetDTO);
        logger.info("end addPaquete");
        return paquete;

    }

    @PutMapping("/paquete/{id}")
    public Paquete modifyPaquete(@RequestBody Paquete Paquete, @PathVariable int id) throws PaqueteNoEncontradoException {
        logger.info("begin modifyPaquete by id" + id);
        Paquete newPaquete = paqueteService.modifyPaquete(id, Paquete);
        logger.info("end modifyPaquete by id " +id);
        return newPaquete;
    }

    @GetMapping("/paquetes/contador")
    public int countPaquete(){
        logger.info("start countPaquete");
        int contador = paqueteService.countPaquete();
        logger.info("end countPaquete");
        return contador;
    }


    @GetMapping("/paquete_extra_price_weight")
    public List<Paquete> getPaqueteExtraPriceByPeso(int peso){
        logger.info("start getPaqueteExtraPriceByPeso");
        List<Paquete> paquetes = paqueteService.getPaqueteExtraPriceByPeso(peso);
        logger.info("end getPaqueteExtraPriceByPeso");
        return paquetes;
    }

    @GetMapping("/paquete/filter")
    public List<Paquete> getPaquetesFilter(int ancho, int alto, int largo) throws PaqueteNoEncontradoException{
        logger.info("start getPaquetesFilter");
        List<Paquete> paquetes = paqueteService.getPaquetesFilter(ancho, alto, largo);
        logger.info("end getPaquetesFilter");
        return paquetes;
    }



    //Codigo para controlar las excepciones de los paquetes
    @ExceptionHandler(PaqueteNoEncontradoException.class)
    public ResponseEntity<RespuestaError> handlePaqueteNoEncontradoException(PaqueteNoEncontradoException pnee) {
        RespuestaError errorResponse = new RespuestaError("1", pnee.getMessage());
        logger.info(pnee.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // TODO Más tipos de excepciones que puedan generar errores

    @ExceptionHandler
    public ResponseEntity<RespuestaError> handleException(Exception exception) {
        RespuestaError errorResponse = new RespuestaError("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
