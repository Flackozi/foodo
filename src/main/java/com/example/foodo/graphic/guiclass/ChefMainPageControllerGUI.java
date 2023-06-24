package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import javafx.scene.control.ScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ChefMainPageControllerGUI {

    private Stage stage;
    private Scene scene;

    public void showKitchenChef(ActionEvent event) throws IOException {
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/myKitchen.fxml"));
        Scene scenePantryView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }


    public void showMyRecipes(ActionEvent event) throws IOException{
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/myRecipes.fxml"));
        Scene scenePantryView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }
    @FXML
    public void showPantry(ActionEvent event) throws IOException{
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/sceneMyPantry.fxml"));
        Scene scenePantryView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    public void showChefProfile(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/sceneChefProfile.fxml"));
        Parent parentRoot = fxmlLoader.load();
        scene = new Scene(parentRoot);
        ChefBean chefBean = Session.getCurrentSession().getChefBean();
        ProfileControllerGUI profileControllerGUI = fxmlLoader.getController();
        profileControllerGUI.setChefInfoProfile(chefBean);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
