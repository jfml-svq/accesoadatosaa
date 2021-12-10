package com.josefco.accesoadatosaa.service;

import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.domain.Conductor;
import com.josefco.accesoadatosaa.exception.ConductorNoEncontradoException;
import com.josefco.accesoadatosaa.repository.CamionRepository;
import com.josefco.accesoadatosaa.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;
    @Autowired
    private CamionRepository camionRepository;

    @Override
    public List<Conductor> findAllConductores() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor findConductor(int id) throws ConductorNoEncontradoException {
        return conductorRepository.findById(id).orElseThrow((ConductorNoEncontradoException::new));
    }


    @Override
    public Conductor deleteConductor(int id) throws ConductorNoEncontradoException {
        Conductor conductor = conductorRepository.findById(id).orElseThrow((ConductorNoEncontradoException::new));
        conductorRepository.delete(conductor);
        return conductor;
    }

    @Override
    public Conductor modifyConductor(int id, Conductor newConductor) throws ConductorNoEncontradoException {
        Conductor conductor = conductorRepository.findById(id).orElseThrow((ConductorNoEncontradoException::new));

        conductor.setNombre(newConductor.getNombre());
        conductor.setApellido(newConductor.getApellido());
        conductor.setTelefono(newConductor.getTelefono());
        conductor.setDireccion(newConductor.getDireccion());
        conductor.setCamiones(newConductor.getCamiones());
        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> findConductorByDireccion(String direccion){
        return conductorRepository.findConductorByDireccion(direccion);
    }

    @Override
    public Conductor saveConductor(Conductor conductor) {
        Conductor newConductor = new Conductor();
        newConductor.setNombre(conductor.getNombre());
        newConductor.setApellido(conductor.getApellido());
        newConductor.setTelefono(conductor.getTelefono());
        newConductor.setDireccion(conductor.getDireccion());
        newConductor.getCamiones()
                .addAll(conductor
                        .getCamiones()
                        .stream()
                        .map(v -> {
                            Camion vv = camionRepository.findById(v.getId()).orElseThrow();
                            vv.getConductores().add(newConductor);
                            return vv;
                        }).collect(Collectors.toList()));
        return conductorRepository.save(newConductor);
    }

}
