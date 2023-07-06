package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RecipeDet2ChefControllerGUI {
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label averageLabel;
    private String interfaceName;

    private Scene scene;
    private Stage stage;
    private String chefName;
    private String name;
    @FXML
    private ImageView recipeImage;
    private Parent root2;
    public void back(ActionEvent event) throws IOException {

        if(Objects.equals(interfaceName, "myChef")){
            root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myChef.fxml")));
            scene = new Scene(root2);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else if(Objects.equals(interfaceName, "myKitchen")){
            root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myKitchen.fxml")));
            scene = new Scene(root2);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }else if(Objects.equals(interfaceName, "myRecipe")){
            root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myRecipes.fxml")));
            scene = new Scene(root2);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else if(Objects.equals(interfaceName, "kitchenSearch")){
            root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/KitchenSearch.fxml")));
            scene = new Scene(root2);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void showIngredients(ActionEvent event) throws IOException, SQLException, ConnectionDbException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1Chef.fxml"));
        Parent parent = fxmlLoader.load();
        scene = new Scene(parent);
        RecipeDet1ChefControllerGUI recipeDet1ChefControllerGUI = fxmlLoader.getController();
        recipeDet1ChefControllerGUI.setRecipe(name, chefName);
        recipeDet1ChefControllerGUI.setInterfaceName(interfaceName);
        recipeDet1ChefControllerGUI.setReview(name, chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void setInterfaceName(String interfaceName) {
        this.interfaceName=interfaceName;
    }

    public void setInfo(String rname, String chefName) {
        this.name=rname;
        this.chefName=chefName;
        RecipeDetController recipeDetController = new RecipeDetController();
        String description = recipeDetController.getDescription(rname);
        descriptionLabel.setText(description);
        String path=recipeDetController.getPath(rname);
        Image image= new Image(path);
        recipeImage.setImage(image);
        recipeImage.setFitHeight(150);
        recipeImage.setFitWidth(150);
        setAverage(rname, chefName);
    }

    private void setAverage(String rname, String chefName) {
        String average = null;
        RecipeDetController recipeDetController=new RecipeDetController();
        average=recipeDetController.setAverage(rname, chefName);

        averageLabel.setText(average.substring(0,3));
    }
}
