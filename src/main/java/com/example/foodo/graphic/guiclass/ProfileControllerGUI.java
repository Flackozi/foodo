package com.example.foodo.graphic.guiclass;

import com.example.foodo.Main;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ProfileControllerGUI {
    public Label labelEmail;
    public Label labelPhone;
    public Label labelLocation;
    @FXML
    private File file = null;
    @FXML
    private ImageView userImg;
    @FXML
    private ImageView chefImg;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelFavoriteFood;
    @FXML
    private Label labelTypeOfDiet;
    @FXML
    private Label labelAccountType;
    private ChefBean chefBean;
    private int account;


    @FXML
    private Label labelWorkplace;

    @FXML
    private Label labelTypeOfCuisine;


    private UserBean userBean;
    private Parent root;
    private Stage stage;
    private Scene scene;



//    public void LoadChefImage(ActionEvent event) throws IOException {
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        FileChooser fileChooser=new FileChooser();
//        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files","*.png","*.jpg"));
//        file = fileChooser.showOpenDialog(stage).getAbsoluteFile();
//        chefImg.setFitHeight(154);
//        chefImg.setFitWidth(154);
//        chefImg.setImage(ImageConverterSupport.fromFileToImage(file));
//        ProfileController profileController=new ProfileController();
//        ChefBean chefBean= Session.getCurrentSession().getChefBean();
//        chefBean.setPath(file.getAbsolutePath());
//        profileController.setChefImage(chefBean);
//    }


    public void setUserInfoProfile(UserBean userBean) throws IOException {

        ProfileController profileController = new ProfileController();
        profileController.getUserInfo(userBean);
        labelUsername.setText(userBean.getUsername());
        labelFavoriteFood.setText(userBean.getUserFavoriteFoodBean());
        labelTypeOfDiet.setText(userBean.getUserTypeOfDietBean());
        labelAccountType.setText("utente base");
        Image image= new Image(userBean.getPath());

        userImg.setImage(image);
    }

    public void setChefInfoProfile(ChefBean chefBean) throws IOException {
        ProfileController profileController = new ProfileController();
        profileController.getChefInfo(chefBean);
        labelUsername.setText(chefBean.getUsername());
        labelTypeOfCuisine.setText(chefBean.getTypeOfCuisine());
        labelWorkplace.setText(chefBean.getWorkplace());
        labelAccountType.setText("chef");
        Image image= new Image(chefBean.getPath());
        chefImg.setImage(image);
    }
    private void setChefInfoProfile2(ChefBean chefBean) {
        ProfileController profileController = new ProfileController();
        profileController.getChefInfo(chefBean);
        labelEmail.setText(chefBean.getEmail());
        labelPhone.setText(chefBean.getNumber());
        labelLocation.setText(chefBean.getLocation());
        System.out.print(chefBean.getPath());
        Image image= new Image(chefBean.getPath());
        chefImg.setImage(image);
    }

    public void BackHome(ActionEvent event) throws IOException {
        if((userBean= Session.getCurrentSession().getUserBean()) != null){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneHomeUser.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/chefMainPage.fxml")));
            scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }

    public void showInfo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/sceneChefProfile.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        ChefBean chefBean = Session.getCurrentSession().getChefBean();
        ProfileControllerGUI profileControllerGUI = fxmlLoader.getController();
        profileControllerGUI.setChefInfoProfile(chefBean);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showContact(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/sceneProfile2.fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        ChefBean chefBean = Session.getCurrentSession().getChefBean();
        ProfileControllerGUI profileControllerGUI = fxmlLoader.getController();
        profileControllerGUI.setChefInfoProfile2(chefBean);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }




}
