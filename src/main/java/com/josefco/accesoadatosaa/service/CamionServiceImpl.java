package com.josefco.accesoadatosaa.service;


import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;
import com.josefco.accesoadatosaa.repository.CamionRepository;
import com.josefco.accesoadatosaa.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionServiceImpl implements CamionService {

    @Autowired
    private CamionRepository camionRepository;
    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Camion> findAllCamiones() {
        return camionRepository.findAll();
    }


    @Override
    public Camion findCamion(int id) throws CamionNoEncontradoException {
            return camionRepository.findById(id).orElseThrow(CamionNoEncontradoException::new);
    }


    @Override
    public Camion deleteCamion(int id) throws CamionNoEncontradoException {
        Camion camion = camionRepository.findById(id).orElseThrow(CamionNoEncontradoException::new);
        camionRepository.delete(camion);
        return camion;
    }

    @Override
    public Camion modifyCamion(int id, Camion newCamion) throws CamionNoEncontradoException {
        Camion camion = camionRepository.findById(id).orElseThrow(CamionNoEncontradoException::new);

        camion.setGasolina(newCamion.getGasolina());
        camion.setMarca(newCamion.getMarca());
        camion.setModelo(newCamion.getModelo());
        camion.setMatricula(newCamion.getMatricula());
        camion.setConductores(newCamion.getConductores());

        return camionRepository.save(camion);
    }

    @Override
    public Camion saveCamion(Camion camion) {
        Camion newCamion = new Camion();
        newCamion.setGasolina(camion.getGasolina());
        newCamion.setMarca(camion.getMarca());
        newCamion.setMatricula(camion.getMatricula());
        newCamion.setModelo(camion.getModelo());
        newCamion.setConductores(camion.getConductores());
        return camionRepository.save(newCamion);
    }

    @Override
    public List<Camion> findCamionesByMarca(String marca) throws CamionNoEncontradoException {
        return camionRepository.findCamionesByMarca(marca);
    }

    /*@Override
    public Camion saveCamion(Camion camion) {

            Camion newCamion = new Camion();
            newCamion.setGasolina(camion.getGasolina());
            newCamion.setMarca(camion.getMarca());
            newCamion.setMatricula(camion.getMatricula());
            newCamion.setModelo(camion.getModelo());
            newCamion.getConductores()
                    .addAll(camion
                            .getConductores()
                            .stream()
                            .map(v -> {
                                Conductor vv = conductorRepository.findById(v.getId());
                                vv.getCamiones().add(newCamion);
                                return vv;
                            }).collect(Collectors.toList()));
            return camionRepository.save(newCamion);
        }*/

}
