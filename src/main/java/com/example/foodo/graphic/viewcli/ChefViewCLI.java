package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.ExceptionController;
import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.graphic.CLIController.ChefCLIController;

import javax.xml.parsers.SAXParser;
import java.util.Scanner;

public class ChefViewCLI {
    private final ChefCLIController chefCLIController;

    public ChefViewCLI(ChefCLIController chefCLIController){
        this.chefCLIController = chefCLIController;
    }

    public void run(){
        Printer.printMessage("\n-------------------------------------------- CHEF HOMEPAGE --------------------------------------------");
        Printer.printMessage(" 1) Pantry \n 2) Profile \n 3) Kitchen \n 4) My Recipes \n");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        try{
            this.chefCLIController.executeCommand(inputLine);
        }catch(CommandNotValidException e){
            ExceptionController.showExceptionCLI(e.getMessage());
            run();
        }
    }
}
