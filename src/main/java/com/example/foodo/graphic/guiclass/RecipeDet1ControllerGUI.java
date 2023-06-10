package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.UserBean;
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
import java.util.*;

public class RecipeDet1ControllerGUI {

    public ImageView recipeImage;
    public Label followLabel;
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
    private String chefName;
    private String userName;
    private UserBean userBean;
    private List<ProductBean> productBeans = new ArrayList<>();
    private String interfaceName;


    public void showDescription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet2.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet2ControllerGUI recipeDet2ControllerGUI = fxmlLoader.getController();
        recipeDet2ControllerGUI.setInterfaceName(interfaceName);
        recipeDet2ControllerGUI.setDescription(rname, chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showReview(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet3.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet3ControllerGUI recipeDet3ControllerGUI = fxmlLoader.getController();
        recipeDet3ControllerGUI.setInterfaceName(interfaceName);
        recipeDet3ControllerGUI.setReview(rname,chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void back(ActionEvent event) throws IOException {

        if(Objects.equals(interfaceName, "myChef")){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myChef.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else if(Objects.equals(interfaceName, "myRecipe")){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myRecipes.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else if(Objects.equals(interfaceName, "myKitchen")){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myKitchen.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else if(Objects.equals(interfaceName, "kitchenSearch")){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/KitchenSearch.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

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


    public void followChef(ActionEvent actionEvent) {
        RecipeDetController recipeDetController= new RecipeDetController();
        this.userName=Session.getCurrentSession().getUserBean().getUsername();
        if(recipeDetController.verifyFollow(userName, chefName)==0){
            //l'utente già seguiva lo chef, quindi lo unfollow
            followLabel.setText("Chef unfollowed");
        }else{
            //l'utente non seguiva ancora lo chef, quindi lo follow
            followLabel.setText("Chef followed");
        }
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName=interfaceName;
    }
}
