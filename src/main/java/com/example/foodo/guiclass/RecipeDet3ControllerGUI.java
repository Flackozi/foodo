package com.example.foodo.guiclass;

import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RecipeDet3ControllerGUI {

    private Parent root;
    private Stage stage;
    private Scene scene;
    private UserBean userBean;
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

    public void OneButtonAction(ActionEvent actionEvent) {
    }

    public void TwoButtonAction(ActionEvent actionEvent) {
    }

    public void ThreeButtonAction(ActionEvent actionEvent) {
    }

    public void FourButtonAction(ActionEvent actionEvent) {
    }

    public void FiveButtonAction(ActionEvent actionEvent) {
    }

    public void showDescription(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/recipeDet2.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showIngredients(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/recipeDet1.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
