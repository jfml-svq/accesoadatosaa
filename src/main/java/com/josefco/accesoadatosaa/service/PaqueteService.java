package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.dto.PaquetDTO;
import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;

import java.util.List;

public interface PaqueteService {


    List<Paquete> findAllPaquetes();
    Paquete findPaquete(int id) throws PaqueteNoEncontradoException;

    Paquete addPaquete(PaquetDTO paquetDTO) throws Exception;
    Paquete deletePaquete(int id) throws PaqueteNoEncontradoException;
    Paquete modifyPaquete(int id, Paquete Paquete) throws PaqueteNoEncontradoException;

    List<Paquete> findPaqueteByColor(String color) throws PaqueteNoEncontradoException;

    int countPaquete();


    List<Paquete> getPaqueteExtraPriceByPeso(int peso);

    List<Paquete> getPaquetesFilter(int ancho, int alto, int largo) throws PaqueteNoEncontradoException;
}