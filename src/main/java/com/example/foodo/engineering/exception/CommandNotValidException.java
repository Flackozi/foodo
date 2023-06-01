package com.example.foodo.engineering.exception;

public class CommandNotValidException extends Exception{

    public CommandNotValidException(){
        super("Command not found\n");
    }
}
