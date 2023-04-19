package com.example.foodo.GUIclass;

import com.example.foodo.ControllerAppl.ProfileController;
import com.example.foodo.engineering.Utils.ImageConverterSupport;
import com.example.foodo.engineering.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.File;
import java.io.IOException;

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

    private UserBean userBean;


    public void LoadImage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files","*.png","*.jpg"));
        file = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        userImg.setImage(ImageConverterSupport.fromFileToImage(file));
    }


    public void setUserInfoProfile(UserBean userBean) throws IOException {
        ProfileController profileController = new ProfileController();

        labelUsername.setText(userBean.getUserUsernameBean());
        labelFavoriteFood.setText(userBean.getUserFavoriteFoodBean());
        labelTypeOfDiet.setText(userBean.getUserTypeOfDietBean());
        labelAccountType.setText("Utente Base");
    }

    public void BackHome(ActionEvent actionEvent) {
    }
}
