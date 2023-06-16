package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.graphic.CLIController.MyRecipesCLIController;

public class MyRecipesViewCLI {
    private final MyRecipesCLIController myRecipesCLIController;

    public MyRecipesViewCLI(MyRecipesCLIController myRecipesCLIController){
        this.myRecipesCLIController = myRecipesCLIController;
    }

    public void run(){
        Printer.printMessage("\n-------------------------------------------- MY RECIPES PAGE --------------------------------------------");
        Printer.printMessage("\n1) Return to home page");
    }
}
