package com.josefco.accesoadatosaa.service;


import com.josefco.accesoadatosaa.domain.Paquete;
import com.josefco.accesoadatosaa.exception.PaqueteNoEncontradoException;
import com.josefco.accesoadatosaa.repository.ConductorRepository;
import com.josefco.accesoadatosaa.repository.PaqueteRepository;
import com.josefco.accesoadatosaa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteServiceImpl implements PaqueteService {


    @Autowired
    private PaqueteRepository paqueteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Paquete> findAllPaquetes() {
        return paqueteRepository.findAll();
    }

    @Override
    public Paquete findPaquete(int id) throws PaqueteNoEncontradoException {
        return paqueteRepository.findById(id);
    }

    @Override
    public Paquete addPaquete(Paquete Paquete) {
        return paqueteRepository.save(Paquete);
    }


    @Override
    public Paquete deletePaquete(int id) throws PaqueteNoEncontradoException {
        Paquete paquete = paqueteRepository.findById(id);
        paqueteRepository.delete(paquete);
        return paquete;
    }

    @Override
    public Paquete modifyPaquete(int id, Paquete newPaquete) throws PaqueteNoEncontradoException {
        Paquete paquete = paqueteRepository.findById(id);

        paquete.setAlto(newPaquete.getAlto());
        paquete.setAncho(newPaquete.getAncho());
        paquete.setLargo(newPaquete.getLargo());
        paquete.setColor(newPaquete.getColor());
        paquete.setPeso(newPaquete.getPeso());
        paquete.setConductor(newPaquete.getConductor());
        paquete.setUsuario(newPaquete.getUsuario());

        return paqueteRepository.save(paquete);
    }
}
