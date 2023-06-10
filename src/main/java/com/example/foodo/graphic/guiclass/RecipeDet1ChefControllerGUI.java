package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecipeDet1ChefControllerGUI {
    public Label averageLabel;
    public TableView tableIngredients;
    public ImageView recipeImage;
    @FXML
    private TableColumn<ProductBean, String> Quantity;

    @FXML
    private TableColumn<ProductBean, String> Name;
    private String rname;
    private String chefName;
    private List<ProductBean> productBeans = new ArrayList<>();
    private String interfaceName;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private String name;

    public void setRecipe(String rname, String chefName) throws SQLException, ConnectionDbException {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Squantity"));
        this.rname=rname;
        this.chefName=chefName;
        RecipeDetController recipeDetController = new RecipeDetController();
        productBeans = recipeDetController.getRecipeIngredients(rname);
        String path=recipeDetController.getPath(rname);
        Image image= new Image(path);
        recipeImage.setImage(image);
        recipeImage.setFitHeight(150);
        recipeImage.setFitWidth(150);
        Iterator<ProductBean> iteratorProduct=productBeans.iterator();
        ObservableList<ProductBean> obl= tableIngredients.getItems();
        while(iteratorProduct.hasNext()){
            ProductBean productBean= iteratorProduct.next();
            obl.add(productBean);
        }

        tableIngredients.setItems(obl);
    }

    public void showDescription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet2Chef.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName=interfaceName;
    }

    private void setAverage(String rname, String chefName) {
        String average = null;
        RecipeDetController recipeDetController=new RecipeDetController();
        average=recipeDetController.setAverage(rname, chefName);

        averageLabel.setText(average.substring(0,3));
    }

    public void setReview(String rname, String chefName) {
        this.name=rname;
        this.chefName=chefName;
        RecipeDetController recipeDetController= new RecipeDetController();
        String path=recipeDetController.getPath(rname);
        Image image= new Image(path);
        recipeImage.setImage(image);
        recipeImage.setFitHeight(150);
        recipeImage.setFitWidth(150);
        setAverage(rname, chefName);

    }

    public void DeleteRecipe(ActionEvent event) throws IOException {
        RecipeDetController recipeDetController=new RecipeDetController();
        recipeDetController.deleteRecipe(name, chefName);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/myRecipes.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
