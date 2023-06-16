package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.CLIController.MyChefCLIController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MyChefViewCLI {
    private final MyChefCLIController myChefCLIController;

    public MyChefViewCLI(MyChefCLIController myChefCLIController) {
        this.myChefCLIController = myChefCLIController;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- MY CHEF PAGE --------------------------------------------");
        Printer.printMessage("\n1) Return to home page");
        List<IngredientBean> ingredientBeans;
        Scanner scanner= new Scanner(System.in);
        String inputLine= scanner.nextLine();
        try{
            this.myChefCLIController.executeCommand(inputLine);
            this.myChefCLIController.retrieveRecipe();
        } catch (ConnectionDbException | SQLException | CommandNotValidException e) {
            throw new RuntimeException(e);
        }
        Printer.printMessage("");
    }

    public void printRecipe(String recipeName, List<ProductBean> productBeans, String description, String average) {
        Printer.printMessage("-----------------------------------");
        Printer.printMessage(recipeName);
        int i;
        for(i=0; i< productBeans.size(); i++){
            Printer.printIngredient(i+1, productBeans.get(i).getName(), productBeans.get(i).getSquantity());
        }
        Printer.printInfo(description, average);
    }
}
