package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.CLIController.ChefCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class ChefViewCLI {
    private final ChefCLIController chefCLIController;

    public ChefViewCLI(ChefCLIController chefCLIController){
        this.chefCLIController = chefCLIController;
    }

    public void run() throws FileNotFoundException, ProductNotFoundException {
        Printer.printMessage("\n-------------------------------------------- CHEF HOMEPAGE --------------------------------------------");
        Printer.printMessage(" 1) Pantry \n 2) Profile \n 3) Kitchen \n 4) My Recipes \n");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        try{
            this.chefCLIController.executeCommand(inputLine);
        }catch(CommandNotValidException | SQLException | ConnectionDbException e){
            ExceptionController.showExceptionCLI(e.getMessage());
            run();
        }
    }
}
