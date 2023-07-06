package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.session.Session;
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
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class RecipeDet3ControllerGUI {
    @FXML
    private ImageView recipeImage;
    @FXML
    private Label followLabel;
    @FXML
    private Label averageLabel;
    @FXML
    private Rating ratingBar;
    private Parent root;

    private Stage stage;
    private Scene scene;
    private UserBean userBean;
    private String name;
    private String chefName;
    private String userName;
    private String interfaceName;



    public void addRating() {
        int value = (int) ratingBar.getRating();
        RecipeDetController recipeDetController = new RecipeDetController();
        recipeDetController.setRate(value, name);
        setAverage(name, chefName);

    }

    public void showDescription(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet2.fxml"));
        Parent parent = fxmlLoader.load();
        scene = new Scene(parent);
        RecipeDet2ControllerGUI recipeDet2ControllerGUI = fxmlLoader.getController();
        recipeDet2ControllerGUI.setInterfaceName(interfaceName);
        recipeDet2ControllerGUI.setDescription(name, chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showIngredients(ActionEvent event) throws IOException, SQLException, ConnectionDbException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1.fxml"));
        Parent parent = fxmlLoader.load();
        scene = new Scene(parent);
        RecipeDet1ControllerGUI recipeDet1ControllerGUI = fxmlLoader.getController();
        recipeDet1ControllerGUI.setInterfaceName(interfaceName);
        recipeDet1ControllerGUI.setRecipe(name, chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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

    private void setAverage(String rname, String chefName) {
        String average = null;
        RecipeDetController recipeDetController = new RecipeDetController();
        average=recipeDetController.setAverage(rname, chefName);
        averageLabel.setText(average);


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
    public void setInterfaceName(String interfaceName) {
        this.interfaceName=interfaceName;
    }

    public void back(ActionEvent event) throws IOException {
        if(Objects.equals(interfaceName, "myChef")){
            changeView("/guiclass/myChef.fxml", event);
        }else if(Objects.equals(interfaceName, "myRecipe")){
            changeView("/guiclass/myRecipes.fxml", event);
        }else if(Objects.equals(interfaceName, "myKitchen")){
            changeView("/guiclass/myKitchen.fxml", event);
        }else if(Objects.equals(interfaceName, "kitchenSearch")){
            changeView("/guiclass/KitchenSearch.fxml", event);
        }
    }

    public void changeView(String path, ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
