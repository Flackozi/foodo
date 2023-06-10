package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.UserDAO;
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
    public Label numberLabel;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private UserBean userBean;

    private RecipeBean recipeBean;
    private MyListener myListener;
    private String Rname;
    private String chefName;

    private String InterfaceName;

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
        if((userBean = Session.getCurrentSession().getUserBean()) != null){
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1.fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);
            RecipeDet1ControllerGUI recipeDet1ControllerGUI = fxmlLoader.getController();
            recipeDet1ControllerGUI.setRecipe(Rname, chefName);
            recipeDet1ControllerGUI.setInterfaceName(InterfaceName);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1Chef.fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);
            RecipeDet1ChefControllerGUI recipeDet1ChefControllerGUI = fxmlLoader.getController();
            recipeDet1ChefControllerGUI.setRecipe(Rname, chefName);
            recipeDet1ChefControllerGUI.setInterfaceName(InterfaceName);
            recipeDet1ChefControllerGUI.setReview(Rname, chefName);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }


    }

    public void setInterfaceName(String interfaceName) {
        this.InterfaceName=interfaceName;
    }
}
