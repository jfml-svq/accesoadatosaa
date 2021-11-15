package com.josefco.accesoadatosaa.controller;


import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CamionController {


    @Autowired
    private CamionService camionService;

    @GetMapping("/camiones")
    public List<Camion> mostrarCamiones(){
        List<Camion> camiones;

        camiones =  camionService.encontrarCamiones();

        return camiones;

    }

}
