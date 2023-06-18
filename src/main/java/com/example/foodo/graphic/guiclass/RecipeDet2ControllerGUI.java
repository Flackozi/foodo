package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
import com.example.foodo.controllerappl.RecipeDetController;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.event.ActionEvent;
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

public class RecipeDet2ControllerGUI{
    public ImageView recipeImage;
    public Label followLabel;
    private Parent root;
        private Stage stage;
        private Scene scene;
    private UserBean userBean;
    private String name;
    private String chefName;
    private String userName;
    public Label descriptionLabel;
    private String interfaceName;

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

    public void showIngredients(ActionEvent event) throws IOException, SQLException, ConnectionDbException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/recipeDet1.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        RecipeDet1ControllerGUI recipeDet1ControllerGUI = fxmlLoader.getController();
        recipeDet1ControllerGUI.setInterfaceName(interfaceName);
        recipeDet1ControllerGUI.setRecipe(name, chefName);
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
        recipeDet3ControllerGUI.setReview(name, chefName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setDescription(String rname, String chefName){
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
