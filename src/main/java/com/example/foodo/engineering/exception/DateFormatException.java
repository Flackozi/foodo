package com.example.foodo.engineering.exception;

public class DateFormatException extends Exception {
    public DateFormatException(String date) {
        super("Inserted date -> " + date + "\nDate format not valid, please retry");
    }
}
