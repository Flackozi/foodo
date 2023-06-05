package com.example.foodo.engineering.exception;

public class NonUsableFunctionException extends Exception{
    public NonUsableFunctionException(){
        super("Functionality not implemented");
    }
}
