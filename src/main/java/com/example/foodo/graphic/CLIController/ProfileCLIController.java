package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.ProfileController;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.ProfileViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ProfileCLIController implements GrapghiCLIController {
    private ProfileViewCLI profileViewCLI;

    private static final String BACKHOME = "1";

    @Override
    public void start() throws SQLException, ConnectionDbException, ProductNotFoundException {
        this.profileViewCLI = new ProfileViewCLI(this);
        this.profileViewCLI.run();
    }

    public UserBean setUserInfoProfile(UserBean userBean){
        ProfileController profileController = new ProfileController();
        return profileController.getUserInfo(userBean);
    }

    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException {
        switch(inputLine){
            case BACKHOME -> {
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
