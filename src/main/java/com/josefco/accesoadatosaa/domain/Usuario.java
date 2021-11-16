package com.josefco.accesoadatosaa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
public class Usuario {

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
    /*@Column(name = "fecha_registro")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;*/
}
