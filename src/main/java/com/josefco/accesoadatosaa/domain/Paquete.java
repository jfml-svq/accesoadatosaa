package com.josefco.accesoadatosaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Paquete")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int ancho;
    @Column
    private int largo;
    @Column
    private int alto;
    @Column
    private int peso;
    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_conductor")
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;



}
