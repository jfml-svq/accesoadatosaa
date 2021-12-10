package com.josefco.accesoadatosaa.exception;

public class CamionNoEncontradoException extends Exception{

    private static final String DEFAULT_ERROR_MESSAGE = "Camion no encontrado";

    public CamionNoEncontradoException(String message)
    {
        super(message);
    }

    public CamionNoEncontradoException() { super(DEFAULT_ERROR_MESSAGE);}



}
