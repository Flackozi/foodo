package com.example.foodo.guiclass;


import com.example.foodo.engineering.Utils.ExceptionControllerGUI;
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
    public void showCreateAccount(ActionEvent event) throws IOException {
       try{
            throw new NonUsableFunctionException();
       }catch(NonUsableFunctionException e){
           ExceptionControllerGUI.showExceptionGUI(e.getMessage());

       }
    }
}
