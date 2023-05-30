package com.example.foodo.engineering.exception;
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
            super("\n**************************************\nUser not found.");
        }
}

