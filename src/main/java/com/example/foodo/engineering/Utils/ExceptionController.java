package com.example.foodo.engineering.Utils;

import com.example.foodo.Main;
import com.example.foodo.graphic.guiclass.AlertControllerGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ExceptionController {
    private ExceptionController(){
        // costruttore privato perché ho tutti i metodi statici
    }
    public static void showExceptionGUI(String msg){

        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initStyle(StageStyle.UNDECORATED);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/Alert.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        AlertControllerGUI alertControllerGUI = fxmlLoader.getController();
        alertControllerGUI.setLabelMSG(msg);
        dialog.setScene(scene);
        dialog.show();


    }

    public static void showExceptionCLI(String message) {
        Printer.printError( "\n**************************************\n" + message + "\n\tPress ENTER to continue");
        ScannerSupport.waitEnter();
    }
}
