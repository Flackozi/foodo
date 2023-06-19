package com.example.foodo.engineering.exception;

import java.security.spec.ECFieldF2m;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(){
        super("Error not found 404: ");
    }
}
