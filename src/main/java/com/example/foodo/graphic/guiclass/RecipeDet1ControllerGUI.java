package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.session.Session;
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
    @FXML
    private ImageView recipeImage;
    @FXML
    private Label followLabel;
    @FXML
    private TableView<ProductBean> tableIngredients;


    @FXML
    private TableColumn<ProductBean, String> quantity;

    @FXML
    private TableColumn<ProductBean, String> name;
    private Parent r;
    private Stage stageB;
    private String chefName;
    private Scene sceneB;
    private String interfaceName;
    private String rname;
    private String userName;
    private UserBean userBean;
    private List<ProductBean> productBeans = new ArrayList<>();





    public void showReview(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet3.fxml"));
        Parent parent = fxmlLoader.load();
        sceneB = new Scene(parent);
        RecipeDet3ControllerGUI recipeDet3ControllerGUI = fxmlLoader.getController();
        recipeDet3ControllerGUI.setInterfaceName(interfaceName);
        recipeDet3ControllerGUI.setReview(rname,chefName);
        stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageB.setScene(sceneB);
        stageB.show();


    }

    public void back(ActionEvent event) throws IOException {

        if(Objects.equals(interfaceName, "myRecipe")){
            r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myRecipes.fxml")));
            sceneB = new Scene(r);
            stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageB.setScene(sceneB);
            stageB.show();
        }else if(Objects.equals(interfaceName, "myChef")){

            r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myChef.fxml")));
            sceneB = new Scene(r);
            stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageB.setScene(sceneB);
            stageB.show();


        }else if(Objects.equals(interfaceName, "kitchenSearch")){

            r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/KitchenSearch.fxml")));
            sceneB = new Scene(r);
            stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageB.setScene(sceneB);
            stageB.show();

        }else if(Objects.equals(interfaceName, "myKitchen")){
            r = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/myKitchen.fxml")));
            sceneB = new Scene(r);
            stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageB.setScene(sceneB);
            stageB.show();
        }


    }


    public void showDescription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet2.fxml"));
        Parent parent = fxmlLoader.load();
        sceneB = new Scene(parent);
        RecipeDet2ControllerGUI recipeDet2ControllerGUI = fxmlLoader.getController();
        recipeDet2ControllerGUI.setInterfaceName(interfaceName);
        recipeDet2ControllerGUI.setDescription(rname, chefName);
        stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageB.setScene(sceneB);
        stageB.show();
    }

    public void followChef() {
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


    public void setRecipe(String rname, String chefName) throws SQLException, ConnectionDbException {
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
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

    public void setInterfaceName(String interfaceName) {
        this.interfaceName=interfaceName;
    }
}
