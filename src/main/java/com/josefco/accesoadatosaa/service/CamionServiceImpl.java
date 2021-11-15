package com.josefco.accesoadatosaa.service;


import com.josefco.accesoadatosaa.repository.CamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamionServiceImpl {

    @Autowired
    private CamionRepository camionRepository;
}
