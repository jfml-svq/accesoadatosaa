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
@Entity(name = "Conductor")
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

    /*@OneToOne
    @JoinColumn(name = "id_camion")
    @JsonBackReference(value = "conductor-camion")
    private Camion camion;*/


    @OneToMany(mappedBy = "conductor")
    private List<Paquete> paquetes;


    @JsonBackReference
    @ManyToMany(mappedBy="conductores")
    private List<Camion> camiones=new ArrayList<>();

    public Conductor(List<Camion> camiones) {
        this.camiones = camiones;
    }

    /*public List<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(List<Camion> camiones) {
        this.camiones = camiones;
    }*/
}
