package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.CLIController.SearchProductCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class SearchProductViewCLI {
    private final SearchProductCLIController searchProductCLIController;
    private boolean fruit=false;
    private boolean spices=false;
    private boolean meat=false;
    private boolean vegetable=false;
    private boolean sweet=false;
    private boolean liquid=false;
    private boolean fish=false;
    private String name="";

    public SearchProductViewCLI(SearchProductCLIController searchProductCLIController) {
        this.searchProductCLIController = searchProductCLIController;
    }

    public void run() throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException {
        Printer.printMessage("\n-------------------------------------------- SEARCH PRODUCT PAGE --------------------------------------------");
        Printer.printMessage("\n 1)Insert the name \n 2)Filter your search \n 3)Pantry \n 4)Return to home page");
        Scanner scanner = new Scanner(System.in);
        String inputLine=scanner.nextLine();
        this.searchProductCLIController.executeCommand(inputLine);
    }

    public void searchName() throws ProductNotFoundException, SQLException, ConnectionDbException {
        Printer.printMessage("\n Insert the name:");
        Scanner scanner= new Scanner(System.in);
        String name= scanner.nextLine();
        this.searchProductCLIController.searchName(name, spices, fruit, meat, vegetable, sweet, liquid, fish);

    }

    public void filterSearch() throws ProductNotFoundException, SQLException, ConnectionDbException {
        Scanner scanner;
        String input;
        Printer.printMessage("\n Fruit? y/n");
        scanner= new Scanner(System.in);
        input=scanner.nextLine();
        if(Objects.equals(input, "y")){
            this.fruit=true;
        }
        Printer.printMessage("\n Spices? y/n");
        scanner= new Scanner(System.in);
        if(Objects.equals(scanner.nextLine(), "y")){
            this.spices=true;
        }
        Printer.printMessage("\n Meat? y/n");
        scanner= new Scanner(System.in);
        if(Objects.equals(scanner.nextLine(), "y")){
            this.meat=true;
        }
        Printer.printMessage("\n Vegetable? y/n");
        scanner= new Scanner(System.in);
        if(Objects.equals(scanner.nextLine(), "y")){
            this.vegetable=true;
        }
        Printer.printMessage("\n Sweet? y/n");
        scanner= new Scanner(System.in);
        if(Objects.equals(scanner.nextLine(), "y")){
            this.sweet=true;
        }
        Printer.printMessage("\n Liquid? y/n");
        scanner= new Scanner(System.in);
        if(Objects.equals(scanner.nextLine(), "y")){
            this.liquid=true;
        }
        Printer.printMessage("\n Fish? y/n");
        scanner= new Scanner(System.in);
        if(Objects.equals(scanner.nextLine(), "y")){
            this.fish=true;
        }

        this.searchProductCLIController.searchName(name, spices, fruit, meat, vegetable, sweet, liquid, fish);

    }

    public void printProduct(String name, String quantity, String typeOfFood, String expiration) {
        Printer.printProductMessage(name, quantity, typeOfFood, expiration);
    }
}
