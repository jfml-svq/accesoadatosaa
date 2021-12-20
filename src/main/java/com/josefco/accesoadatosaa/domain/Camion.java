package com.josefco.accesoadatosaa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    /*@OneToOne(mappedBy = "camion")
    private Conductor conductor;*/

    @JsonBackReference
    @ManyToMany
    @JoinTable(name="camion_conductor",joinColumns=@JoinColumn(name="camion_id"),
            inverseJoinColumns=@JoinColumn(name="conductor_id"))
    private List<Conductor> conductores=new ArrayList<>();

    public Camion(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    /*public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }*/
}
