package com.example.foodo.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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
    public void showPantryUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneMyPantry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showProfileUser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/sceneProfile.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        ProfileControllerGUI profileControllerGUI = fxmlLoader.getController();
        if((userBean= Session.getCurrentSession().getUserBean()) != null){
            profileControllerGUI.setUserInfoProfile(userBean);
        }


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showKitchenUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/guiclass/myKitchen.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showMyChefUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/guiclass/myChef.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
