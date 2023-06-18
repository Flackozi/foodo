package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.graphic.CLIController.AddProductCLIController;

import java.sql.SQLException;
import java.util.Scanner;

public class AddProductViewCLI {
    private final AddProductCLIController addProductCLIController;

    public AddProductViewCLI(AddProductCLIController addProductCLIController) {
        this.addProductCLIController = addProductCLIController;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- ADD PRODUCT PAGE --------------------------------------------");
        Scanner scanner= new Scanner(System.in);
        String inputLine;
        Printer.printMessage("\n Insert name of product:");
        inputLine= scanner.nextLine();
        String name=inputLine;
        Printer.printMessage("\n Insert quantity:");
        inputLine= scanner.nextLine();
        int quantity= Integer.parseInt(inputLine);
        Printer.printMessage("\n Insert expiration day");
        inputLine= scanner.nextLine();
        String day= inputLine;
        Printer.printMessage("\n Insert expiration month:");
        inputLine= scanner.nextLine();
        String month= inputLine;
        Printer.printMessage("\n Insert expiration year:");
        inputLine= scanner.nextLine();
        String year= inputLine;
        String expiration= day + "/" + month + "/" + year;
        Printer.printMessage("\n Insert type of food. Choose from: fruit, meat, vegetable, liquid, spices, sweet, fish, other ");
        inputLine= scanner.nextLine();
        String type=inputLine;
        try{
            this.addProductCLIController.addProduct(name, quantity, type, expiration, day, month, year);
        }catch (SQLException e){
            run();
        }


    }
}
