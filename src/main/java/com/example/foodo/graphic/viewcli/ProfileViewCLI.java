package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.CLIController.ProfileCLIController;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProfileViewCLI {

    private final ProfileCLIController profileCLIController;
    private UserBean userBean;
    private ChefBean chefBean;

    public ProfileViewCLI(ProfileCLIController profileCLIController) {
        this.profileCLIController = profileCLIController;
    }

    public void run() throws SQLException, ConnectionDbException {
        Printer.printMessage("\n-------------------------------------------- PROFILE PAGE --------------------------------------------");
        Printer.printMessage("\n INFORMATION:");
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        if ((userBean = Session.getCurrentSession().getUserBean()) != null) {

            Printer.printMessage("\n Username: ");
            Printer.printMessage(userBean.getUsername());
            Printer.printMessage("\nFavorite food: ");
            Printer.printMessage(userBean.getUserFavoriteFoodBean());
            Printer.printMessage("\nType of diet: ");
            Printer.printMessage(userBean.getUserTypeOfDietBean());
            Printer.printMessage("\nAccount type: \nUtente base");
            Printer.printMessage("\n 1) Return to home page\n");
            inputLine = scanner.nextLine();
            try {
                this.profileCLIController.executeCommand(inputLine);
            } catch (CommandNotValidException e) {
                run();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        }
        if ((chefBean = Session.getCurrentSession().getChefBean()) != null) {
            Printer.printMessage("\nUsername: ");
            Printer.printMessage(chefBean.getUsername());
            Printer.printMessage("\nType of cuisine: ");
            Printer.printMessage(chefBean.getTypeOfCuisine());
            Printer.printMessage("\nWork place: ");
            Printer.printMessage(chefBean.getWorkplace());
            Printer.printMessage("\nAccount type: \nChef");
            Printer.printMessage("\nEmail: ");
            Printer.printMessage(chefBean.getEmail());
            Printer.printMessage("\nPhone number: ");
            Printer.printMessage(chefBean.getNumber());
            Printer.printMessage("\nLocation: ");
            Printer.printMessage(chefBean.getLocation());
            Printer.printMessage("\n 1) Return to home page\n");
            inputLine = scanner.nextLine();
            try {
                this.profileCLIController.executeCommand(inputLine);
            } catch (CommandNotValidException e) {
                run();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
