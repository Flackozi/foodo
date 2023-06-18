package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.LoginController;
import com.example.foodo.engineering.Utils.ExceptionController;
import com.example.foodo.engineering.bean.LoginBean;
import com.example.foodo.engineering.exception.NotFoundException;
import com.example.foodo.engineering.exception.UserNotFoundException;
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

import java.io.IOException;
import java.util.Objects;


public class LoginControllerGUI {

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
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/mainSceneLogin.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

//    public void loginButtonOnAction (ActionEvent event) throws IOException {
//        ((Node)event.getSource()).getScene().getWindow().hide();
//        Stage stage = Main.getStage();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sceneLogin.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//    }


    public void showUserHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneHomeUser.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void showChefHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/chefMainPage.fxml")));
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

            }else
                throw new UserNotFoundException();

        }catch(UserNotFoundException  e){
            ExceptionController.showExceptionGUI(e.getMessage());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
