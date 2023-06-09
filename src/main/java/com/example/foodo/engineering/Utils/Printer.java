package com.example.foodo.engineering.Utils;

import java.util.logging.Logger;

public class Printer {
    static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Printer(){}
    public static void printError(String error){
        log.info(error);
    }
    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printProductMessage(String name, int quantity, String expiration, String typeOfFood) {
        System.out.print(name);
        System.out.print(" | ");
        System.out.print(quantity);
        System.out.print(" | ");
        System.out.print(expiration);
        System.out.print(" | ");
        System.out.print(typeOfFood);
        System.out.print("\n");
    }
}