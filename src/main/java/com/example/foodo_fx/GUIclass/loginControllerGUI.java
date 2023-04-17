package com.example.foodo_fx.GUIclass;

import com.example.foodo_fx.ControllerAppl.LoginController;
import com.example.foodo_fx.engineering.connection.ConnectionDB;
import com.example.foodo_fx.Main;
import com.example.foodo_fx.engineering.bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.StageStyle;
import java.sql.Connection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;


public class loginControllerGUI {

    @FXML
    private Label loginMessage;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    public void backHome(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage = Main.getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainSceneLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

//    public void loginButtonOnAction (ActionEvent event) throws IOException {
//        ((Node)event.getSource()).getScene().getWindow().hide();
//        Stage stage = Main.getStage();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sceneLogin.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//    }


    public void showUserHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUIclass/sceneHomeUser.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void showChefHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUIclass/chefMainPage.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/GUIclass/chefMainPage.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
////        ChefMainPageControllerGUI chefMainPageControllerGUI  = fxmlLoader.getController();
////        chefMainPageControllerGUI.goToHomePage();
//        return scene;
    }

    public void login(ActionEvent event) throws IOException{
        Scene scene;
        try{
            LoginBean loginBean = new LoginBean(usernameTextField.getText(), passwordPasswordField.getText());
            LoginController loginController = new LoginController();
            loginController.checkLogin(loginBean);

            if(loginBean.getAccountType() == 1){
                loginController.completeChefLogin(loginBean);
//                scene = showChefHomePage();
//                Main.getStage().setScene(scene);
                showChefHomePage(event);
            } else if(loginBean.getAccountType() == 2){
                loginController.completeUserLogin(loginBean);
//                scene = showUserHomePage();
//                Main.getStage().setScene(scene);
                showUserHomePage(event);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
