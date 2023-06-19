package com.example.foodo.engineering.exception;



public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(){
        super("Error not found 404: ");
    }
}
