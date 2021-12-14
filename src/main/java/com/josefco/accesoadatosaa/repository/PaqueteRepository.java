package com.josefco.accesoadatosaa.repository;


import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteRepository extends CrudRepository<Paquete, Integer> {

    List<Paquete> findAll();
    List<Paquete> findPaqueteByColor(String color) throws PaqueteNoEncontradoException;
    //Paquete findById(int id);

}
