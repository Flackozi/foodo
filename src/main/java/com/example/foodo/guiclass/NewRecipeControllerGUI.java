package com.example.foodo.guiclass;

import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.model.IngredientModel;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.RecipeModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class NewRecipeControllerGUI {

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField QuantityTextField;

    @FXML
    private Button addButton;

    private List<IngredientModel> ingredients;

    @FXML
    private TableView IngredientsTable;

    @FXML
    private TableColumn<IngredientModel, String> Name;

    @FXML
    private TableColumn<IngredientModel, Integer> Quantity;

    @FXML
    private TextArea DescriptionTextArea;

    @FXML
    private Button confirmButton;

    public void addIngredient(javafx.event.ActionEvent event){
        IngredientBean ingredientBean=new IngredientBean();

        ingredientBean.setName(Name.getText());
        ingredientBean.setQuantity(Quantity.getText());
        IngredientModel ingredientModel=new IngredientModel(Name.getText(), Quantity.getText());

        ingredients.add(ingredientModel);
        IngredientsTable.getItems().add(ingredientModel);

    }

    public void confirmRecipe (javafx.event.ActionEvent event){



        RecipeModel recipeModel= new RecipeModel();
    }

    public void backHome(javafx.event.ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }



}
