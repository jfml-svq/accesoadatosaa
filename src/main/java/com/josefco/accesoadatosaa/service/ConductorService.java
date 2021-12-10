package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Conductor;
import com.josefco.accesoadatosaa.exception.ConductorNoEncontradoException;

import java.util.List;

public interface ConductorService {

    List<Conductor> findAllConductores();
    Conductor findConductor(int id) throws ConductorNoEncontradoException;
    Conductor deleteConductor (int id) throws  ConductorNoEncontradoException;
    Conductor modifyConductor (int id, Conductor Conductor) throws ConductorNoEncontradoException;

    List<Conductor> findConductorByDireccion(String direccion) throws ConductorNoEncontradoException;

    Conductor saveConductor(Conductor conductor);
}
