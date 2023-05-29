package com.example.foodo.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RecipeDet2ControllerGUI{
        private Parent root;
        private Stage stage;
        private Scene scene;
    private UserBean userBean;
    private String name;
    public Label descriptionLabel;

    public void back(ActionEvent event) throws IOException {
        if((userBean= Session.getCurrentSession().getUserBean()) != null){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myChef.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myRecipes.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void showIngredients(ActionEvent event) throws IOException, SQLException, ConnectionDbException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet1ControllerGUI recipeDet1ControllerGUI = fxmlLoader.getController();
        recipeDet1ControllerGUI.setRecipe(name);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showReview(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet3.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet3ControllerGUI recipeDet3ControllerGUI = fxmlLoader.getController();
        recipeDet3ControllerGUI.setDescription(name);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setDescription(String rname){
        this.name=rname;

    }
}
