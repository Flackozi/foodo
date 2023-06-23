package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.exception.RecipeNotFoundException;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.controllercli.KitchenCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class KitchenViewCLI {

    KitchenCLIController kitchenCLIController;

    public KitchenViewCLI(KitchenCLIController kitchenCLIController) {
        this.kitchenCLIController=kitchenCLIController;
    }

    public void run() throws FileNotFoundException, ProductNotFoundException {
        Printer.printMessage("\n-------------------------------------------- KITCHEN PAGE --------------------------------------------");
        Printer.printMessage("\n1) Insert ingredients \n2) Search recipe \n3) Return to home page");
        Scanner scanner= new Scanner(System.in);
        String inputLine= scanner.nextLine();
        try {
            this.kitchenCLIController.executeCommand(inputLine);
        } catch (CommandNotValidException | SQLException | ConnectionDbException | RecipeNotFoundException e) {
            ExceptionController.showExceptionCLI(e.getMessage());
            run();
        }
    }

    private void moreInfo() throws SQLException, ConnectionDbException {
        Printer.printMessage("\nEnter the name of the recipe you want to see:");
        Scanner scanner= new Scanner(System.in);
        String recipeName= scanner.nextLine();
        Printer.printMessage("Enter the chef name of the recipe you want to see:");
        String chefName= scanner.nextLine();
        kitchenCLIController.viewRecipeInfo(recipeName, chefName);
    }

    public void searchRecipe() throws SQLException, ConnectionDbException, RecipeNotFoundException {
        Printer.printMessage("\n Enter name of recipe");
        Scanner scanner= new Scanner(System.in);
        String name= scanner.nextLine();
        this.kitchenCLIController.searchRecipeByName(name);
        moreInfo();
    }

    public void insertIngredient() throws SQLException, ConnectionDbException {
        Printer.printMessage("Enter first ingredient:");
        Scanner scanner= new Scanner(System.in);
        String ingredient1= scanner.nextLine();
        String ingredient2 = "";
        String ingredient3="";
        String ingredient4="";
        String ingredient5="";
        Printer.printMessage("Want to add another ingredient? y/n");
        if(Objects.equals(scanner.nextLine(), "y")) {
            Printer.printMessage("Enter second ingredient:");
            ingredient2= scanner.nextLine();
            Printer.printMessage("Want to add another ingredient? y/n");
            if(Objects.equals(scanner.nextLine(), "y")) {
                Printer.printMessage("Enter second ingredient:");
                ingredient3= scanner.nextLine();
                Printer.printMessage("Want to add another ingredient? y/n");
                if(Objects.equals(scanner.nextLine(), "y")) {
                    Printer.printMessage("Enter second ingredient:");
                    ingredient4= scanner.nextLine();
                    Printer.printMessage("Want to add another ingredient? y/n");
                    if(Objects.equals(scanner.nextLine(), "y")) {
                        Printer.printMessage("Enter second ingredient:");
                        ingredient5= scanner.nextLine();
                    }
                }
            }
        }
        this.kitchenCLIController.searchRecipeByIngredients(ingredient1, ingredient2, ingredient3, ingredient4, ingredient5);
        moreInfo();
    }

    public void print(int i, String string1, String string2) {
        System.out.print(i);
        System.out.print(") ");
        System.out.print(string1);
        System.out.print(" ");
        System.out.println(string2);

    }

    public void printInfo(String description, String average) {
        Printer.printMessage("Description:");
        Printer.printMessage(description);
        Printer.printMessage("Review:");
        Printer.printMessage(average);
    }
}
