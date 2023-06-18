package com.example.foodo.graphic.CLIController;

import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.AddRecipeViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class AddRecipeCLIController implements GrapghiCLIController{
    private static final String CONFIRM="1";

    private AddRecipeViewCLI addRecipeViewCLI;

    @Override
    public void start() throws SQLException, ConnectionDbException, FileNotFoundException {
        this.addRecipeViewCLI = new AddRecipeViewCLI(this);
        this.addRecipeViewCLI.run();
    }

    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException {
        switch (inputLine){
            case CONFIRM -> {
                if(Session.getCurrentSession().getUserBean()!= null){
                    UserCLIController userCLIController= new UserCLIController();
                    userCLIController.start();
                }else{
                    ChefCLIController chefCLIController = new ChefCLIController();
                    chefCLIController.start();
                }

            }
        }
    }
}
