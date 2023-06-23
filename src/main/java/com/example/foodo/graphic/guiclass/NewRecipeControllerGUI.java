package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.RecipeController;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.utils.ImageConverterSupport;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.FieldEmptyException;
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
import java.util.Objects;

public class NewRecipeControllerGUI{

    @FXML
    private TextField recipeName;
    @FXML
    private TextField quantiyTextField;
    @FXML
    public TextField nameTextField;

    @FXML
    private Button addButton;
    @FXML
    private ImageView recipeImage;
    @FXML
    private Button imageButton;

    private File file;

    @FXML
    private TableView ingredientsTable;

    @FXML
    private TableColumn<IngredientModel, String> name;

    @FXML
    private TableColumn<IngredientModel, Integer> quantity;

    @FXML
    public TextArea descriptionTextArea;

    @FXML
    public ScrollPane scrollPane;

    List<IngredientBean> ingredients=new ArrayList<>();

    String path;


    public void addIngredient(){
        try{

            if(Objects.equals(nameTextField.getText(), "")){
                throw new FieldEmptyException("Name");
            }
            if(Objects.equals(quantiyTextField.getText(), "")){
                throw new FieldEmptyException("Quantity");
            }
            name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            IngredientBean ingredientBean=new IngredientBean(nameTextField.getText(), quantiyTextField.getText());
            IngredientModel ingredientModel=new IngredientModel(nameTextField.getText(), quantiyTextField.getText());
            ingredientsTable.getItems().add(ingredientModel);
            ingredients.add(ingredientBean);

        }catch(FieldEmptyException e){
            ExceptionController.showExceptionGUI(e.getMessage());
        }


    }

    public void confirmRecipe (ActionEvent event) throws SQLException, IOException, ConnectionDbException {

        try{

            if(Objects.equals(recipeName.getText(), "")){
                throw new FieldEmptyException("Recipe Name");
            }
            if(Objects.equals(descriptionTextArea.getText(), "")){
                throw new FieldEmptyException("Description");
            }


            RecipeBean recipeBean=new RecipeBean();
            recipeBean.setRecipeName(recipeName.getText());
            recipeBean.setDescription(descriptionTextArea.getText());
            ChefBean chefBean=new ChefBean();
            chefBean= Session.getCurrentSession().getChefBean();
            recipeBean.setChefName(chefBean.getUsername());
            recipeBean.setPath(path);

            //verificato che tutti i dati in RecipeModel siano stati inseriti correttamente
            RecipeController recipeController=new RecipeController();
            recipeController.saveRecipe(recipeBean);
            recipeController.saveIngredients(ingredients);

        }catch (FieldEmptyException e){
            ExceptionController.showExceptionGUI(e.getMessage());

        }

        backHome(event);

    }

    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
        ingredients.clear();
    }


    public void insertImage(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files","*.png","*.jpg"));
        file = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        recipeImage.setFitHeight(148);
        recipeImage.setFitWidth(158);
        recipeImage.setImage(ImageConverterSupport.fromFileToImage(file));
        path= file.getAbsolutePath();
    }
}
