package com.josefco.accesoadatosaa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paquetes")
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
    @Column(name = "fecha")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate fecha;


    @ManyToOne
    @JoinColumn(name = "conductor_id")
    @JsonBackReference(value = "conductor-paquete")
    private Conductor conductor;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference(value = "usuario-paquete")
    private Usuario usuario;



}
