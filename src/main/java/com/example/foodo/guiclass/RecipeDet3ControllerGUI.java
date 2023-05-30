package com.example.foodo.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RecipeDet3ControllerGUI {

    private Parent root;

    private Stage stage;
    private Scene scene;
    private UserBean userBean;
    private String name;
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

    public void OneButtonAction(ActionEvent event) {
        int value = 1;
        RecipeDetController recipeDetController = new RecipeDetController();
        recipeDetController.setRate(value, name);

    }

    public void TwoButtonAction(ActionEvent event) {
        int value = 2;
        RecipeDetController recipeDetController = new RecipeDetController();
        recipeDetController.setRate(value, name);
    }

    public void ThreeButtonAction(ActionEvent event) {
        int value = 3;
        RecipeDetController recipeDetController = new RecipeDetController();
        recipeDetController.setRate(value, name);
    }

    public void FourButtonAction(ActionEvent event) {
        int value = 4;
        RecipeDetController recipeDetController = new RecipeDetController();
        recipeDetController.setRate(value, name);
    }

    public void FiveButtonAction(ActionEvent event) {
        int value = 5;
        RecipeDetController recipeDetController = new RecipeDetController();
        recipeDetController.setRate(value, name);
    }

    public void showDescription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet2.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet2ControllerGUI recipeDet2ControllerGUI = fxmlLoader.getController();
        recipeDet2ControllerGUI.setDescription(name);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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

    public void setDescription(String rname) {
        this.name=rname;

    }
}
