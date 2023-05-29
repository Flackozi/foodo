package com.example.foodo.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.IngredientBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.IngredientModel;
import com.example.foodo.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class RecipeDet1ControllerGUI {

    @FXML
    private TableView<ProductBean> tableIngredients;


    @FXML
    private TableColumn<ProductBean, String> Quantity;

    @FXML
    private TableColumn<ProductBean, String> Name;
    private Parent root;
    private Stage stage;
    private Scene scene;

    private String rname;
    private UserBean userBean;
    private List<ProductBean> productBeans = new ArrayList<>();



    public void showDescription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet2.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet2ControllerGUI recipeDet2ControllerGUI = fxmlLoader.getController();
        recipeDet2ControllerGUI.setDescription(rname);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showReview(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet3.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet3ControllerGUI recipeDet3ControllerGUI = fxmlLoader.getController();
        recipeDet3ControllerGUI.setDescription(rname);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

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

    public void setRecipe(String rname) throws SQLException, ConnectionDbException {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Squantity"));
        this.rname=rname;
        RecipeDetController recipeDetController = new RecipeDetController();
        productBeans = recipeDetController.getRecipeIngredients(rname);
        Iterator<ProductBean> iteratorProduct=productBeans.iterator();
        ObservableList<ProductBean> obl= tableIngredients.getItems();
        while(iteratorProduct.hasNext()){
            ProductBean productBean= iteratorProduct.next();
            obl.add(productBean);
        }

        tableIngredients.setItems(obl);

    }


}
