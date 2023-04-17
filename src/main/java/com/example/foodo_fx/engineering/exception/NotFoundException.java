package com.example.foodo_fx.engineering.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String msg){
        super("Error not found 404: " + msg);
    }
}