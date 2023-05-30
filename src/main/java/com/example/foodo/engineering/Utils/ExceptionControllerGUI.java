package com.example.foodo.engineering.Utils;

import com.example.foodo.Main;
import com.example.foodo.guiclass.AlertControllerGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ExceptionControllerGUI {
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
}
