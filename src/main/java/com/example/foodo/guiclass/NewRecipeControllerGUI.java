package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.RecipeController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.Utils.ImageConverterSupport;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.model.IngredientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewRecipeControllerGUI{

    public Button confirmButton;

    public TextField RecipeName;
    public TextField QuantiyTextField;
    @FXML
    public TextField NameTextField;

    @FXML
    public Button addButton;
    public ImageView RecipeImage;
    public Button imageButton;

    private File file;

    @FXML
    private TableView IngredientsTable;

    @FXML
    private TableColumn<IngredientModel, String> NameColumn;

    @FXML
    private TableColumn<IngredientModel, Integer> QuantityColumn;

    @FXML
    public TextArea DescriptionTextArea;

    @FXML
    public ScrollPane scrollPane;

    List<IngredientBean> ingredients=new ArrayList<>();

    String path;


    public void addIngredient(javafx.event.ActionEvent event){
        try{
            NameColumn.setCellValueFactory(new PropertyValueFactory<>("NameColumn"));
            QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QuantityColumn"));
            System.out.print(NameTextField.getText());
            IngredientBean ingredientBean=new IngredientBean(NameTextField.getText(), QuantiyTextField.getText());
            IngredientsTable.getItems().add(ingredientBean);
            ingredients.add(ingredientBean);

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
        recipeBean.setPath(path);

        //verificato che tutti i dati in RecipeModel siano stati inseriti correttamente
        RecipeController recipeController=new RecipeController();
        recipeController.saveRecipe(recipeBean);
        recipeController.saveIngredients(ingredients);

    }

    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }


    public void insertImage(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files","*.png","*.jpg"));
        file = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        RecipeImage.setImage(ImageConverterSupport.fromFileToImage(file));
        path= file.getPath();
    }
}
