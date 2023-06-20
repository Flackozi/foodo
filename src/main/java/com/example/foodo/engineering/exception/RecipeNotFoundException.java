package com.example.foodo.engineering.exception;

public class RecipeNotFoundException extends Exception{
    public RecipeNotFoundException() {
        super("\n**************************************\nRecipe not found.");
    }
}
