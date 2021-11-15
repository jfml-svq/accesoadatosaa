package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Camion;

import java.util.List;

public interface CamionService {


    List<Camion> encontrarCamiones();
    void encontrarCamionPorId(int id);

    Camion añadirCamion(Camion camion);
    Camion borrarCamion(Camion camion);
    Camion modificarCamion(Camion camion);


}
