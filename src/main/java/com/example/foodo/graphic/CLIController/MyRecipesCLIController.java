package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.MyRecipeController;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.CLIController.GrapghiCLIController;
import com.example.foodo.graphic.viewcli.MyRecipesViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyRecipesCLIController implements GrapghiCLIController {
    private MyRecipesViewCLI myRecipesViewCLI;
    private static final String BACK="1";
    private static final String ADDRECIPE="2";

    @Override
    public void start() throws SQLException, ConnectionDbException, FileNotFoundException {
        this.myRecipesViewCLI = new MyRecipesViewCLI(this);
        this.myRecipesViewCLI.run();
    }

    public void retrieveMyRecipe() throws SQLException, ConnectionDbException {
        List<RecipeBean> recipeBeans= new ArrayList<>();
        MyRecipeController myRecipeController = new MyRecipeController();
        recipeBeans = myRecipeController.retriveRecipeItem();
        for(int i=0; i<recipeBeans.size(); i++){
            List<ProductBean> ingredientBeans= new ArrayList<>();
            RecipeDetController recipeDetController=new RecipeDetController();
            ingredientBeans=recipeDetController.getRecipeIngredients(recipeBeans.get(i).getRecipeName());
            String average= recipeDetController.setAverage(recipeBeans.get(i).getRecipeName(), recipeBeans.get(i).getChefName());
            String description=recipeDetController.getDescription(recipeBeans.get(i).getRecipeName());
            this.myRecipesViewCLI.printRecipe(recipeBeans.get(i).getRecipeName(), ingredientBeans, description, average);
        }

    }


    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException {
        switch(inputLine){
            case BACK -> {
                if(Session.getCurrentSession().getUserBean()!= null){
                    UserCLIController userCLIController= new UserCLIController();
                    userCLIController.start();
                }else{
                    ChefCLIController chefCLIController = new ChefCLIController();
                    chefCLIController.start();
                }
            }case ADDRECIPE -> {
                    AddRecipeCLIController addRecipeCLIController = new AddRecipeCLIController();
                    addRecipeCLIController.start();
                    this.start();
            }
            default -> throw new CommandNotValidException();
        }
    }
}
