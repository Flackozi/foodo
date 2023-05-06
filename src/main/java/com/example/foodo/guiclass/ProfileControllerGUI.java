package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.ProfileController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.Utils.ImageConverterSupport;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ProfileControllerGUI {
    @FXML
    private File file = null;
    @FXML
    private ImageView userImg;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFavoriteFood;
    @FXML
    private Label labelTypeOfDiet;
    @FXML
    private Label labelAccountType;

    @FXML
    private Label labelWorkplace;

    @FXML
    private Label labelTypeOfCuisine;


    private UserBean userBean;
    private Parent root;
    private Stage stage;
    private Scene scene;


    public void LoadImage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files","*.png","*.jpg"));
        file = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        userImg.setImage(ImageConverterSupport.fromFileToImage(file));
//        UserBean userBean= Session.getCurrentSession().getUserBean();
//        userBean.setProfileImg(file);
    }


    public void setUserInfoProfile(UserBean userBean) throws IOException {
        ProfileController profileController = new ProfileController();
        userBean= Session.getCurrentSession().getUserBean();
        labelUsername.setText(userBean.getUserUsernameBean());
        labelFavoriteFood.setText(userBean.getUserFavoriteFoodBean());
        labelTypeOfDiet.setText(userBean.getUserTypeOfDietBean());
        labelAccountType.setText("utente base");
//        userImg.setImage(ImageConverterSupport.fromFileToImage(userBean.getProfileImg()));
    }

    public void setChefInfoProfile(ChefBean chefBean) throws IOException {
        ProfileController profileController = new ProfileController();
        chefBean= Session.getCurrentSession().getChefBean();
        labelUsername.setText(chefBean.getUsername());
        labelTypeOfCuisine.setText(chefBean.getTypeOfCuisine());
        labelWorkplace.setText(chefBean.getWorkplace());
        labelAccountType.setText("chef");
    }



    public void BackHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneHomeUser.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
