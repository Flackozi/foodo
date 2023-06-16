package com.example.foodo.graphic.viewcli;

import com.example.foodo.graphic.CLIController.UserCLIController;
import com.example.foodo.engineering.Utils.ExceptionController;
import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.exception.CommandNotValidException;

import java.util.Scanner;

public class UserViewCLI {
    private final UserCLIController userCLIController;

    public UserViewCLI(UserCLIController userCLIController) {
        this.userCLIController=userCLIController;
    }
    public void run() {
        Printer.printMessage("\n-------------------------------------------- USER HOMEPAGE --------------------------------------------");
        Printer.printMessage(" 1) Pantry \n 2) Profile \n 3) Kitchen \n 4) Mychef \n");
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        try {
            this.userCLIController.executeCommand(inputLine);
        } catch (CommandNotValidException e) {
            ExceptionController.showExceptionCLI(e.getMessage());
            run();
        }
    }

}
