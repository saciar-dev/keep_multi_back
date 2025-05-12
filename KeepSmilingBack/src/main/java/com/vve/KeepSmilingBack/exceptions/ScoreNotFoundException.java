package com.vve.KeepSmilingBack.exceptions;

public class ScoreNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Score no encontrado";
    }
}
