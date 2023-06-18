package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.MyChefController;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.MyChefViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyChefCLIController implements  GrapghiCLIController{

    private static final String BACK="1";
    private static final String REVIEW="2";
    MyChefViewCLI myChefViewCLI;
    @Override
    public void start() throws SQLException, ConnectionDbException, FileNotFoundException {
        this.myChefViewCLI= new MyChefViewCLI(this);
        this.myChefViewCLI.run();
    }

    public void  retrieveRecipe() throws SQLException, ConnectionDbException {
        List<RecipeBean> recipeBeans= new ArrayList<>();
        MyChefController myChefController= new MyChefController();
        recipeBeans=myChefController.retriveItem();
        for(int i=0; i<recipeBeans.size(); i++){
            List<ProductBean> ingredientBeans= new ArrayList<>();
            RecipeDetController recipeDetController=new RecipeDetController();
            ingredientBeans=recipeDetController.getRecipeIngredients(recipeBeans.get(i).getRecipeName());
            String average= recipeDetController.setAverage(recipeBeans.get(i).getRecipeName(), recipeBeans.get(i).getChefName());
            String description=recipeDetController.getDescription(recipeBeans.get(i).getRecipeName());
            this.myChefViewCLI.printRecipe(recipeBeans.get(i).getRecipeName(), ingredientBeans, description, average);
        }
    }



    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException {
        switch(inputLine){
            case BACK -> {
//                if(Session.getCurrentSession().getUserBean()!= null){
//                    UserCLIController userCLIController= new UserCLIController();
//                    userCLIController.start();
//                }else{
//                    ChefCLIController chefCLIController = new ChefCLIController();
//                    chefCLIController.start();
//                }
                UserCLIController userCLIController= new UserCLIController();
                userCLIController.start();
            } case REVIEW -> {
                this.myChefViewCLI.leaveReview();
                UserCLIController userCLIController= new UserCLIController();
                userCLIController.start();
            }
            default -> throw new CommandNotValidException();
        }
    }

    public void leaveReview(String rate, String name) {
        RecipeDetController recipeDetController= new RecipeDetController();
        recipeDetController.setRate(Integer.parseInt(rate), name);
    }
}
