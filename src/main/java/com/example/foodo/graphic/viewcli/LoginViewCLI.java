package com.example.foodo.graphic.viewcli;

import com.example.foodo.graphic.CLIController.LoginCLIController;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.NonUsableFunctionException;

import java.util.Scanner;

public class LoginViewCLI {
    private final LoginCLIController loginCLIController;
    public LoginViewCLI(LoginCLIController loginCLIControllerCurrent) {
        this.loginCLIController= loginCLIControllerCurrent;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- MAIN PAGE --------------------------------------------");
        Printer.printMessage(" 1) Login \n 2) Login with Google \n 3) Sign up \n");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        try {
            this.loginCLIController.executeCommand(inputLine);
        } catch (CommandNotValidException | NonUsableFunctionException e) {
            run();
        }
    }

    public void getCredentials() {
        Printer.printMessage("\n Insert Username:");
        Scanner scanner = new Scanner(System.in);
        String username= scanner.nextLine();
        Printer.printMessage("\n Insert Password:");
        String password= scanner.nextLine();

        try{
            loginCLIController.checkLogin(username, password);
        } catch (Exception e){
            Printer.printError(e.getMessage());
        }
    }
}
