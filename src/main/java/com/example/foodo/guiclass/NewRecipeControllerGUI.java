package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.controllerappl.RecipeController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.model.IngredientModel;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.RecipeModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class NewRecipeControllerGUI{

    public Button confirmButton;

    public TextField RecipeName;
    public TextField QuantiyTextField;
    @FXML
    public TextField NameTextField;

    @FXML
    public Button addButton;

    public List<IngredientModel> ingredients;

    @FXML
    private TableView IngredientsTable;

    @FXML
    private TableColumn<IngredientModel, String> Name;

    @FXML
    private TableColumn<IngredientModel, Integer> Quantity;

    @FXML
    public TextArea DescriptionTextArea;

    @FXML
    public ScrollPane scrollPane;

    List<IngredientModel> ingredientModels=new ArrayList<>();


    public void addIngredient(javafx.event.ActionEvent event){
        try{
            Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            System.out.print(NameTextField.getText());
            IngredientModel ingredientModel=new IngredientModel(NameTextField.getText(), QuantiyTextField.getText());
            IngredientsTable.getItems().add(ingredientModel);
            ingredientModels.add(ingredientModel);

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void confirmRecipe (ActionEvent event) throws SQLException, IOException {
        RecipeBean recipeBean=new RecipeBean();
        recipeBean.setRecipeName(RecipeName.getText());
        recipeBean.setDescription(DescriptionTextArea.getText());
        ChefBean chefBean=new ChefBean();
        chefBean= Session.getCurrentSession().getChefBean();
        recipeBean.setChefName(chefBean.getUsername());

        //verificato che tutti i dati in RecipeModel siano stati inseriti correttamente
        RecipeController recipeController=new RecipeController();
        recipeController.saveRecipe(recipeBean);

    }

    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }


    public void insertImage(ActionEvent event) {
    }
}
