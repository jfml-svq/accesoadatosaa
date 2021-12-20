package com.josefco.accesoadatosaa.repository;


import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteRepository extends CrudRepository<Paquete, Integer> {

    List<Paquete> findAll();
    List<Paquete> findPaqueteByColor(String color) throws PaqueteNoEncontradoException;


    //SQL
    @Query(value = "SELECT COUNT(*) FROM \"paquetes\"", nativeQuery = true)
    int countPaquetes();

    @Query(value = "SELECT * FROM \"paquetes\" WHERE \"ancho\" = :ancho AND  \"alto\" = :alto AND \"largo\" = :largo", nativeQuery = true)
    List<Paquete> getPaquetesFilter(int ancho, int alto, int largo);

    //JPQL
    @Query("SELECT p FROM paquetes p WHERE peso < :peso")
    List<Paquete> getPaqueteExtraPriceByPeso(int peso);


}
