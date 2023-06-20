package com.example.foodo.engineering.exception;

public class DateFormatNotValidException extends Exception{
    public DateFormatNotValidException(){
        super("date not valid, please insert a new date");
    }
}
