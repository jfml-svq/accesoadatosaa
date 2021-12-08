package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Conductor;
import com.josefco.accesoadatosaa.exception.ConductorNoEncontradoException;
import com.josefco.accesoadatosaa.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Conductor> findAllConductores() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor findConductor(int id) throws ConductorNoEncontradoException {
        return conductorRepository.findById(id);
    }

    @Override
    public Conductor addConductor(Conductor Conductor) {
        return conductorRepository.save(Conductor);
    }

    @Override
    public Conductor deleteConductor(int id) throws ConductorNoEncontradoException {
        Conductor conductor = conductorRepository.findById(id);
        conductorRepository.delete(conductor);
        return conductor;
    }

    @Override
    public Conductor modifyConductor(int id, Conductor newConductor) throws ConductorNoEncontradoException {
        Conductor conductor = conductorRepository.findById(id);

        conductor.setNombre(newConductor.getNombre());
        conductor.setApellido(newConductor.getApellido());
        conductor.setTelefono(newConductor.getTelefono());
        conductor.setCamion(newConductor.getCamion());

        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> findConductorByDireccion(String direccion) throws ConductorNoEncontradoException {
        return conductorRepository.findConductorByDireccion(direccion);
    }
}
