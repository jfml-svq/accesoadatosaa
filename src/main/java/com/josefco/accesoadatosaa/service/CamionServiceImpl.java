package com.josefco.accesoadatosaa.service;



import com.josefco.accesoadatosaa.domain.Camion;
import com.josefco.accesoadatosaa.exception.CamionNoEncontradoException;
import com.josefco.accesoadatosaa.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionServiceImpl implements CamionService {

    @Autowired
    private CamionRepository camionRepository;

    @Override
    public List<Camion> findAllCamiones() {
        return camionRepository.findAll();
    }


    @Override
    public Camion findCamion(int id) throws CamionNoEncontradoException {
        return camionRepository.findById(id);
    }

    @Override
    public void repairCamion(Camion Camion) {

    }

    @Override
    public Camion addCamion(Camion Camion) {
        return camionRepository.save(Camion);
    }

    @Override
    public Camion deleteCamion(int id) throws CamionNoEncontradoException {
        Camion camion = camionRepository.findById(id);
        camionRepository.delete(camion);
        return camion;
    }

    @Override
    public Camion modifyCamion(int id, Camion newCamion) throws CamionNoEncontradoException {
        Camion camion = camionRepository.findById(id);

        camion.setGasolina(newCamion.getGasolina());
        camion.setMarca(newCamion.getMarca());
        camion.setModelo(newCamion.getModelo());
        camion.setMatricula(newCamion.getMatricula());

        return camionRepository.save(camion);
    }
}
