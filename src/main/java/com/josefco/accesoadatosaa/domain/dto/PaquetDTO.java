package com.josefco.accesoadatosaa.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
    @NoArgsConstructor
    public class PaquetDTO {

        private int ancho;
        private int largo;
        private int alto;
        private int peso;
        private String color;
        @JsonFormat(pattern="dd-MM-yyyy")
        private LocalDate fecha;
        private int usuario;
        private int conductor;

    }

