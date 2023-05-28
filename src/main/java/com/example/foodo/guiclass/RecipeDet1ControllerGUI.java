package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class RecipeDet1ControllerGUI {

    @FXML
    public TableView tableIngredients;


    @FXML
    private TableColumn<ProductModel, String> Quantity;

    @FXML
    private TableColumn<ProductModel, String> Name;
    private Parent root;
    private Stage stage;
    private Scene scene;

    private String rname;
    private UserBean userBean;


    public RecipeDet1ControllerGUI(String name){
        this.rname = name;
    }
    public void showDescription(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/recipeDet2.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showReview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/recipeDet3.fxml")));
        scene = new Scene(root);
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

    public void initialize(String rname){
        RecipeDetController recipeDetController = new RecipeDetController();
        List<ProductBean> productBeans = new ArrayList<>();

        try {

            //String name = setRname(rname);
            System.out.print(rname);
            productBeans = recipeDetController.getRecipeIngredients(rname);


            Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            ObservableList obl = FXCollections.observableArrayList(productBeans);
            tableIngredients.setItems(obl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
