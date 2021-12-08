package com.josefco.accesoadatosaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Camion")
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

    @OneToOne(mappedBy = "camion")
    private Conductor conductor;

}
