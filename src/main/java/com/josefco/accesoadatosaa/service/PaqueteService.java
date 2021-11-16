package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;

import java.util.List;

public interface PaqueteService {


    List<Paquete> findAllPaquetes();
    Paquete findPaquete(int id) throws PaqueteNoEncontradoException;

    Paquete addPaquete(Paquete Paquete);
    Paquete deletePaquete(int id) throws PaqueteNoEncontradoException;
    Paquete modifyPaquete(int id, Paquete Paquete) throws PaqueteNoEncontradoException;
}
