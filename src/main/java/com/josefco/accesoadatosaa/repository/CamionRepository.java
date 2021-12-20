package com.josefco.accesoadatosaa.repository;

import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamionRepository extends CrudRepository<Camion, Integer> {

    List<Camion> findAll();

    List<Camion> findCamionesByMarca(String marca) throws CamionNoEncontradoException;
    //Camion findById(int id);

    @Query("SELECT COUNT(*) FROM camiones")
    int countCamiones();
}
