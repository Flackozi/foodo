package com.example.foodo.engineering.exception;

public class FieldEmptyException extends Exception{
    public FieldEmptyException(String msg){
        super("The field "+msg+" is empty");
    }
}
