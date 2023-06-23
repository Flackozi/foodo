package com.example.foodo.graphic.guiclass;


import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.exception.NonUsableFunctionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccessControllerGUI {
    @FXML
    public void showLogin(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneLogin.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    @FXML
    public void showCreateAccount(ActionEvent event) {
       try{
            throw new NonUsableFunctionException();
       }catch(NonUsableFunctionException e){
           ExceptionController.showExceptionGUI(e.getMessage());

       }
    }
}
