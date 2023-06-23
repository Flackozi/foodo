package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.controllercli.MyChefCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MyChefViewCLI {
    private final MyChefCLIController myChefCLIController;

    public MyChefViewCLI(MyChefCLIController myChefCLIController) {
        this.myChefCLIController = myChefCLIController;
    }

    public void run() throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException {
        Printer.printMessage("\n-------------------------------------------- MY CHEF PAGE --------------------------------------------");
        this.myChefCLIController.retrieveRecipe();
        Printer.printMessage("\n1) Return to home page \n2) Leave a review");
        List<IngredientBean> ingredientBeans;
        Scanner scanner= new Scanner(System.in);
        String inputLine= scanner.nextLine();
        try{
            this.myChefCLIController.executeCommand(inputLine);
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
            Printer.printIngredient(i+1, productBeans.get(i).getName(), productBeans.get(i).getQuantity());
        }
        Printer.printInfo(description, average);
    }

    public void leaveReview(){
        Scanner scanner;
        String name;
        String rate;
        Printer.printMessage("Recipe name:");
        scanner= new Scanner(System.in);
        name= scanner.nextLine();
        Printer.printMessage("Leave a grade from 1 to 5");
        scanner=new Scanner(System.in);
        rate= scanner.nextLine();
        this.myChefCLIController.leaveReview(rate, name);

    }
}
