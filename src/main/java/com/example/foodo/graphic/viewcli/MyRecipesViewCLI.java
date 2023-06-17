package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.CLIController.MyRecipesCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MyRecipesViewCLI {
    private final MyRecipesCLIController myRecipesCLIController;

    public MyRecipesViewCLI(MyRecipesCLIController myRecipesCLIController){
        this.myRecipesCLIController = myRecipesCLIController;
    }

    public void run() throws SQLException, ConnectionDbException, FileNotFoundException {
        Printer.printMessage("\n-------------------------------------------- MY RECIPES PAGE --------------------------------------------");
        this.myRecipesCLIController.retrieveMyRecipe();
        Printer.printMessage("\n1) Return to home page \n2) Add new recipe");
        List<IngredientBean> ingredientBeans;
        Scanner scanner= new Scanner(System.in);
        String inputLine= scanner.nextLine();
        try{
            //this.myRecipesCLIController.retrieveMyRecipe();
            this.myRecipesCLIController.executeCommand(inputLine);
        } catch (ConnectionDbException | SQLException | CommandNotValidException e) {
            throw new RuntimeException(e);
        }

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
