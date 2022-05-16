package com.josefco.accesoadatosaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity(name = "conductores")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
    @Column
    private String direccion;

    @OneToMany(mappedBy = "conductor")
    private List<Paquete> paquetes;


    @ManyToMany //(mappedBy = "conductores")
    private List<Camion> camiones;

    public Conductor (){
        camiones = new ArrayList<>();
    }
}
