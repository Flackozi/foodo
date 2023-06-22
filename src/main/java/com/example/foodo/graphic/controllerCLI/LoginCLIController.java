package com.example.foodo.graphic.controllerCLI;

import com.example.foodo.controllerappl.LoginController;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.bean.LoginBean;
import com.example.foodo.engineering.exception.*;
import com.example.foodo.graphic.viewcli.LoginViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class LoginCLIController implements GrapghiCLIController{
    private static final String LOGIN = "1";
    private static final String LOGIN_WITH_GOOGLE = "2";
    private static final String SIGN_UP = "3";
    private LoginViewCLI loginViewCLI;
    @Override
    public void start() {
        this.loginViewCLI= new LoginViewCLI(this);
        this.loginViewCLI.run();
    }

    public void executeCommand(String inputLine) throws NonUsableFunctionException, CommandNotValidException {
        switch (inputLine){
            case LOGIN -> this.loginViewCLI.getCredentials();
            case LOGIN_WITH_GOOGLE, SIGN_UP -> throw new NonUsableFunctionException();
            default -> throw new CommandNotValidException();
        }
    }

    public void checkLogin (String username, String password) throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException, NotFoundException {
        try{
            LoginBean loginBean= new LoginBean(username, password);
            LoginController loginController= new LoginController();
            loginController.checkLogin(loginBean);

            if(loginBean.getAccountType()==1){
                loginController.completeChefLogin(loginBean);
                ChefCLIController chefCLIController= new ChefCLIController();
                chefCLIController.start();
            }else if(loginBean.getAccountType()==2){
                loginController.completeUserLogin(loginBean);
                UserCLIController userCLIController= new UserCLIController();
                userCLIController.start();
            }else{
                throw new UserNotFoundException();
            }
        }catch(UserNotFoundException e){
            ExceptionController.showExceptionCLI(e.getMessage());
            start();
        }

    }
}
