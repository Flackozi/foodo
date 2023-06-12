package com.example.foodo.graphic.CLIController;

import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.graphic.viewcli.ChefViewCLI;

public class ChefCLIController {
    ChefViewCLI chefViewCLI;
    private static final String PANTRY="1";
    private static final String PROFILE="2";
    private static final String KITCHEN="3";
    private static final String MYRECIPES="4";


    public void start() {
        this.chefViewCLI = new ChefViewCLI(this);
        this.chefViewCLI.run();
    }

    public void executeCommand(String inputLine) throws CommandNotValidException {
        switch(inputLine){
            case PANTRY -> {
                PantryCLIController pantryCLIController=new PantryCLIController();
                pantryCLIController.start();
            }case PROFILE -> {
                ProfileCLIController profileCLIController=new ProfileCLIController();
                profileCLIController.start();
                //this.start();
            }case KITCHEN -> {
                KitchenCLIController kitchenCLICOntroller= new KitchenCLIController();
                kitchenCLICOntroller.start();
            }case MYRECIPES -> {
                MyRecipesCLIController myRecipesCLIController = new MyRecipesCLIController();
                myRecipesCLIController.start();
            }
            default -> throw new CommandNotValidException();
        }
    }
}
