package com.josefco.accesoadatosaa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity(name = "camiones")
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String matricula;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private int gasolina;


    @JsonBackReference
    @ManyToMany
    private List<Conductor> conductores;

    public Camion(){
        conductores = new ArrayList<>();
    }

    /*public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }*/
}
