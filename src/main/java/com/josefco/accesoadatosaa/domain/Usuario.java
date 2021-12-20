package com.josefco.accesoadatosaa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
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
    @Column(name = "fecha_reg")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate fechaReg;

    /*@OneToMany(mappedBy = "usuario")
    private List<Paquete> paquete;*/

    @OneToMany(mappedBy = "usuario")
    private List<Paquete> paquetes;
}
