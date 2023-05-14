package com.example.foodo.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.bean.ChefBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ChefMainPageControllerGUI {

    private Parent root;
    private Stage stage;
    private Scene scene;
    private ChefBean chefBean;

    public void showKitchenChef(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/myKitchen.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    public void showMyChef(ActionEvent actionEvent) {
//        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneMyPantry.fxml"));
//        Scene scenePantryView = new Scene(scenePantryParent);
//
//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        window.setScene(scenePantryView);
//        window.show();
    }

    public void showMyRecipes(ActionEvent event) throws IOException{
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/myRecipes.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }
    @FXML
    public void showPantry(ActionEvent event) throws IOException{
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneMyPantry.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    public void showChefProfile(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/sceneChefProfile.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        ProfileControllerGUI profileControllerGUI = fxmlLoader.getController();
        profileControllerGUI.setChefInfoProfile(chefBean);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
