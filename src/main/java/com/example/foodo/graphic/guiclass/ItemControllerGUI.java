package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.UserBean;
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

public class ItemControllerGUI {
    @FXML
    public Label recipeNameLabel;
    @FXML
    public Label chefLabel;
    @FXML
    public ImageView img;
    @FXML
    private Label numberLabel;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private UserBean userBean;

    private RecipeBean recipeBean;
    private MyListener myListener;
    private String rname;
    private String chefName;

    private String interfaceName;

    public void setData(RecipeBean recipeBean, MyListener myListener, Integer j, String recipeName, String chefName) {
        this.recipeBean = recipeBean;
        this.myListener = myListener;
        this.rname = recipeName;
        this.chefName=chefName;
        recipeNameLabel.setText(recipeBean.getRecipeName());
        numberLabel.setText(String.valueOf(j));
        String path = recipeBean.getPath();
        chefLabel.setText(recipeBean.getChefName());
        Image image = new Image(path);
        img.setImage(image);

    }



    public void openRecipeInfo(ActionEvent event) throws IOException, SQLException, ConnectionDbException {
        if((userBean = Session.getCurrentSession().getUserBean()) != null){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1.fxml"));
            Parent parent = fxmlLoader.load();
            scene = new Scene(parent);
            RecipeDet1ControllerGUI recipeDet1ControllerGUI = fxmlLoader.getController();
            recipeDet1ControllerGUI.setRecipe(rname, chefName);
            recipeDet1ControllerGUI.setInterfaceName(interfaceName);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1Chef.fxml"));
            Parent parent = fxmlLoader.load();
            scene = new Scene(parent);
            RecipeDet1ChefControllerGUI recipeDet1ChefControllerGUI = fxmlLoader.getController();
            recipeDet1ChefControllerGUI.setRecipe(rname, chefName);
            recipeDet1ChefControllerGUI.setInterfaceName(interfaceName);
            recipeDet1ChefControllerGUI.setReview(rname, chefName);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }


    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName =interfaceName;
    }
}
