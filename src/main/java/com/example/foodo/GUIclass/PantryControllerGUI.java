package com.example.foodo.GUIclass;
import com.example.foodo.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantryControllerGUI implements Initializable {
    @FXML
    private TableColumn<Product, DatePicker> Expiration;

    @FXML
    private Button HomeButton;

    @FXML
    private TableColumn<Product, String> Name;

    @FXML
    private TableColumn<Product, String> Quantity;

    @FXML
    private TableColumn<Product, String> TypeOfFood;

    @FXML
    private ImageView addNewProduct;

    @FXML
    private DatePicker expirationDate;

    @FXML
    private TextArea nameText;

    @FXML
    private TextArea quantityText;

    @FXML
    private ChoiceBox<String> typePicker;

    @FXML
    private TableView<Product> tablePantry;


    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneHomeUser.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    @FXML
    public void showSearch(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneSearchProduct.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    @FXML
    public void showLogin(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneLogin.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    private String[] typeOfFood = {"spices", "fruit", "meat", "vegetable", "sweet", "sweet", "liquid", "fish"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        typePicker.getItems().addAll(typeOfFood);
    }

    public void addNewProduct(ActionEvent actionEvent) {
    }

    public void deleteProduct(ActionEvent actionEvent) {
    }

    public void searchProduct(ActionEvent actionEvent) {
    }

    public void showPantry(ActionEvent actionEvent) {
    }
}
