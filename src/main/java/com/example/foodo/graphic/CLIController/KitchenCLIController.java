package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.KitchenController;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.controllerappl.SearchRecipeController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.KitchenBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.SearchRecipeBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.KitchenViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitchenCLIController implements GrapghiCLIController{
    KitchenViewCLI kitchenViewCLI;
    private static final String INSERTINGREDIENT="1";

    private static final String SEARCHRECIPE="2";
    private static final String BACK="3";

    @Override
    public void start() throws FileNotFoundException {
        this.kitchenViewCLI= new KitchenViewCLI(this);
        this.kitchenViewCLI.run();
    }

    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException {
        switch(inputLine){
            case INSERTINGREDIENT -> {
                this.kitchenViewCLI.insertIngredient();
            }case SEARCHRECIPE -> {
                this.kitchenViewCLI.searchRecipe();
            }case BACK -> {
                if(Session.getCurrentSession().getUserBean()!= null){
                    UserCLIController userCLIController= new UserCLIController();
                    userCLIController.start();
                }else{
                    ChefCLIController chefCLIController = new ChefCLIController();
                    chefCLIController.start();
                }
            }
            default -> throw new CommandNotValidException();
        }
    }

    public void searchRecipeByName(String name) {
        SearchRecipeBean searchRecipeBean= new SearchRecipeBean();
        searchRecipeBean.setRecipeName(name);
        List<RecipeBean> recipeBeans=new ArrayList<>();


        SearchRecipeController searchRecipeController= new SearchRecipeController();
        recipeBeans=searchRecipeController.searchRecipe(searchRecipeBean);
        for(int i=0; i<recipeBeans.size(); i++){
            this.kitchenViewCLI.print(i+1,recipeBeans.get(i).getRecipeName(), recipeBeans.get(i).getChefName());
        }
    }

    public void searchRecipeByIngredients(String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5) throws SQLException, ConnectionDbException {
        KitchenBean kitchenBean= new KitchenBean(ingredient1, ingredient2, ingredient3, ingredient4, ingredient5);
        List<RecipeBean> recipeBeans= new ArrayList<>();
        KitchenController kitchenController= new KitchenController();
        recipeBeans=kitchenController.searchRecipe(kitchenBean);
        for(int i=0; i<recipeBeans.size(); i++){
            this.kitchenViewCLI.print(i+1,recipeBeans.get(i).getRecipeName(), recipeBeans.get(i).getChefName());
        }
    }

    public void viewRecipeInfo(String recipeName, String chefName) throws SQLException, ConnectionDbException {
        RecipeDetController recipeDetController= new RecipeDetController();
        List<ProductBean> productBeans= new ArrayList<>();
        productBeans=recipeDetController.getRecipeIngredients(recipeName);
        for(int i=0; i< productBeans.size() ;i++){
            this.kitchenViewCLI.print(i+1, productBeans.get(i).getName(), productBeans.get(i).getSquantity());
        }
        String description= recipeDetController.getDescription(recipeName);
        String average= recipeDetController.setAverage(recipeName, chefName);
        this.kitchenViewCLI.printInfo(description, average);
    }
}
