package com.josefco.accesoadatosaa.repository;

import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.domain.Conductor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Long> {

    List<Conductor> findAll();
    Conductor findById(int id);
}
