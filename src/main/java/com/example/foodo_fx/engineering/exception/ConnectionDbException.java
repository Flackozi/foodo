package com.example.foodo_fx.engineering.exception;

public class ConnectionDbException extends Exception {
    public ConnectionDbException() {
        super("Error during DB connection");
    }
}
