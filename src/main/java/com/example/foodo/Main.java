package com.example.foodo;

import com.example.foodo.graphic.controllerCLI.LoginCLIController;
import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    private static Stage stage;
    private static Stage clistage;



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/mainSceneLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 390, 844);
        stage.setTitle("Foodo");
        stage.setScene(scene);
        stage.show();
    }
    public static void setStage(Stage stage) {
        Main.stage = stage;
    }
    public static Stage getStage(){
        return stage;
    }
    public static Stage getClistage() {
        return clistage;
    }

    public static void setClistage(Stage clistage) {
        Main.clistage = clistage;
    }
    public static void main(String[] args) throws ConnectionDbException {
        ConnectionDB.getConnection();
        Scanner reader= new Scanner(System.in);
        int selection;
        Printer.printMessage("Which type of view do you want to use? \n\n 1) Graphic Interface \n 2)Command Line Interface \n Insert the number: ");

        while(true){
            selection= reader.nextInt();
            if(selection==1){
                launch();
                break;
            }else if (selection==2){
                LoginCLIController loginCLIController= new LoginCLIController();
                loginCLIController.start();
            }else{
                Printer.printError("Number not valid, please insert 1 o 2");
            }
        }
    }
}

