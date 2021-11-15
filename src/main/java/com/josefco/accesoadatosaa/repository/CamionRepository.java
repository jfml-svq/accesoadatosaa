package com.josefco.accesoadatosaa.repository;

import com.josefco.accesoadatosaa.domain.Camion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamionRepository extends CrudRepository<Camion, Long> {

    List<Camion> encontrarCamiones();
    void encontrarCamionPorId(int id);
}
