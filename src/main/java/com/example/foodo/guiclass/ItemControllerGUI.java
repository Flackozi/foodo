package com.example.foodo.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ItemControllerGUI {
    @FXML
    public Label recipeNameLabel;
    @FXML
    public Label chefLabel;
    @FXML
    public ImageView img;
    public Label numberLabel;
    private Parent root;
    private Stage stage;
    private Scene scene;

    private RecipeBean recipeBean;
    private MyListener myListener;
    private String Rname;
    private String chefName;

    public void setData(RecipeBean recipeBean, MyListener myListener, Integer j, String recipeName, String chefName) {
        this.recipeBean = recipeBean;
        this.myListener = myListener;
        this.Rname = recipeName;
        this.chefName=chefName;
        recipeNameLabel.setText(recipeBean.getRecipeName());
        numberLabel.setText(String.valueOf(j));
        String path = recipeBean.getPath();
        chefLabel.setText(recipeBean.getChefName());
        Image image = new Image(path);
        img.setImage(image);

    }



    public void openRecipeInfo(ActionEvent event) throws IOException, SQLException, ConnectionDbException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet1ControllerGUI recipeDet1ControllerGUI = fxmlLoader.getController();
        recipeDet1ControllerGUI.setRecipe(Rname, chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
