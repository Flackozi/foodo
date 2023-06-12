package com.example.foodo.graphic.CLIController;

import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.graphic.CLIController.GrapghiCLIController;
import com.example.foodo.graphic.viewcli.MyRecipesViewCLI;

import java.util.List;

public class MyRecipesCLIController implements GrapghiCLIController {
    private MyRecipesViewCLI myRecipesViewCLI;

    @Override
    public void start() {
        this.myRecipesViewCLI = new MyRecipesViewCLI(this);
        this.myRecipesViewCLI.run();
    }


}
