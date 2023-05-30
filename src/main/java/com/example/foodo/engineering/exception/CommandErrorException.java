package com.example.foodo.engineering.exception;

public class CommandErrorException extends Exception{
    public CommandErrorException() {
        super("Command not found\n");
    }
}
