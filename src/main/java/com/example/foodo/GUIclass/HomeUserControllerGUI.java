package com.example.foodo.GUIclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeUserControllerGUI {

    private Parent root;
    private Stage stage;
    private Scene scene;

    private UserBean userBean;
    public void showPantryUser(ActionEvent actionEvent) {
    }

    public void showProfileUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/GUIclass/sceneProfile.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        ProfileControllerGUI profileControllerGUI = fxmlLoader.getController();
        profileControllerGUI.setUserInfoProfile(userBean);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showKitchenUser(ActionEvent actionEvent) {
    }

    public void showMyCHefUser(ActionEvent actionEvent) {
    }
}
