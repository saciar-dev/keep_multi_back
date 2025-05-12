package com.vve.KeepSmilingBack.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Jugador no encontrado";
    }
}
