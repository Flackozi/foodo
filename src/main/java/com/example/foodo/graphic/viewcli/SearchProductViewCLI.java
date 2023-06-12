package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.graphic.CLIController.SearchProductCLIController;

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

    public void run() {
        Printer.printMessage("\n-------------------------------------------- SEARCH PAGE --------------------------------------------");
        Printer.printMessage("\n 1)Insert the name \n 2)Filter your search \n 3)Pantry");
        Scanner scanner = new Scanner(System.in);
        String inputLine=scanner.nextLine();
        this.searchProductCLIController.executeCommand(inputLine);
    }

    public void searchName() {
        Printer.printMessage("\n Insert the name:");
        Scanner scanner= new Scanner(System.in);
        String name= scanner.nextLine();
        this.searchProductCLIController.searchName(name, spices, fruit, meat, vegetable, sweet, liquid, fish);

    }

    public void filterSearch() {
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

    public void printProduct(String name, int quantity, String typeOfFood, String expiration) {
        Printer.printProductMessage(name, quantity, typeOfFood, expiration);
    }
}
