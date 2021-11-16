package com.josefco.accesoadatosaa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaError {

    private String internalError;
    private String message;

}