package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;

import java.util.List;

public interface CamionService {

    List<Camion> findAllCamiones();
    Camion findCamion(int id) throws CamionNoEncontradoException;
    Camion deleteCamion(int id) throws CamionNoEncontradoException;
    Camion modifyCamion(int id, Camion Camion) throws CamionNoEncontradoException;

    Camion saveCamion(Camion camion);

    List<Camion> findCamionesByMarca(String marca) throws CamionNoEncontradoException;

    int countCamiones();
}
