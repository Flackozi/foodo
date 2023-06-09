package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.NonUsableFunctionException;
import com.example.foodo.graphic.CLIController.PantryCLIController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PantryView {

    private final PantryCLIController pantryCLIController;

    public PantryView(PantryCLIController pantryCLIController) {
        this.pantryCLIController = pantryCLIController;
    }


    public void run() {
        Printer.printMessage("\n-------------------------------------------- PANTRY PAGE --------------------------------------------");
        Printer.printMessage("\n Product in pantry:");
        List<ProductBean> productBeanList= new ArrayList<>();

        try{
            productBeanList=this.pantryCLIController.retrieveProducts();
            Printer.printMessage("name, quantity, expiration, type of food");
            for(ProductBean productBean: productBeanList){
                Printer.printProductMessage(productBean.getName(), productBean.getQuantity(), productBean.getExpiration(), productBean.getTypeOfFood());
            }
        }catch(SQLException | ConnectionDbException e){
            run();
        }

        Printer.printMessage("\n 1) Insert new product\n 2) Return to home page\n 3) Search product \n 4) Delete Product \n");
        Scanner scanner= new Scanner(System.in);
        String inputLine= scanner.nextLine();
        try{
            this.pantryCLIController.executeCommand(inputLine);
        }catch (CommandNotValidException e){
            run();
        }
    }
}
