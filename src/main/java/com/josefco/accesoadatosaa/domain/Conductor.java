package com.josefco.accesoadatosaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "id_camion")
    private Camion camion;

    @OneToMany(mappedBy = "conductor")
    private List<Paquete> paquete;


}
