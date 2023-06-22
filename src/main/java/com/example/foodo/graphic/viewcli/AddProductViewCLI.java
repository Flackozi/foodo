package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.exception.DateFormatNotValidException;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.graphic.controllerCLI.AddProductCLIController;

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
        String quantity= inputLine;

        try{
            Printer.printMessage("\n Insert expiration day:");
            inputLine= scanner.nextLine();
            //fare controllo sintattico con Exceptiraton day
            String day= inputLine;
            if((Integer.parseInt(day) > 31) && (Integer.parseInt(day) < 1)){
                throw new DateFormatNotValidException();
            }
            Printer.printMessage("\n Insert expiration month:");
            inputLine= scanner.nextLine();
            String month= inputLine;
            if((Integer.parseInt(month) > 12) && (Integer.parseInt(month) < 1)){
                throw new DateFormatNotValidException();
            }
            Printer.printMessage("\n Insert expiration year:");
            inputLine= scanner.nextLine();
            String year= inputLine;
            if(Integer.parseInt(year) < 2023){
                throw new DateFormatNotValidException();
            }
            String expiration= day + "/" + month + "/" + year;
            Printer.printMessage("\n Insert type of food. Choose from: fruit, meat, vegetable, liquid, spices, sweet, fish, other ");
            inputLine= scanner.nextLine();
            String type=inputLine;
            this.addProductCLIController.addProduct(name, quantity, type, expiration, day, month, year);
        }catch (DateFormatNotValidException | SQLException e){
            ExceptionController.showExceptionCLI("errore nell'inserimento della data");
            run();
        }



    }
}
