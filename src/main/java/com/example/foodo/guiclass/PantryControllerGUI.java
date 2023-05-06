package com.example.foodo.guiclass;
import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.model.ProductModel;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PantryControllerGUI  implements Initializable{
    @FXML
    private TableColumn<ProductModel, DatePicker> Expiration;

    @FXML
    private Button HomeButton;

    @FXML
    private TableColumn<ProductModel, String> Name;

    @FXML
    private TableColumn<ProductModel, Integer> Quantity;

    @FXML
    private TableColumn<ProductModel, String> TypeOfFood;

    @FXML
    private ImageView addNewProduct;

    @FXML
    private DatePicker expirationDate;

    @FXML
    private TextField nameText;

    @FXML
    private TextField quantityField;

    @FXML
    private ChoiceBox<String> typeOfFoodPicker;

    @FXML
    private TableView<ProductModel> tablePantry;


    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    @FXML
    public void showSearch(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneSearchProduct.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    @FXML
    public void showLogin(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneLogin.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }

    private String[] typeOfFood = {"spices", "fruit", "meat", "vegetable", "sweet", "sweet", "liquid", "fish"};

    public void initialize(URL url, ResourceBundle resourceBundle){

        typeOfFoodPicker.getItems().addAll(typeOfFood);
        typeOfFoodPicker.setOnAction(this::getType);
    }
    public void getType(ActionEvent event){
        String myType = typeOfFoodPicker.getValue();
    }
    public void addNewProduct(ActionEvent actionEvent) throws SQLException {
        ProductBean productBean = new ProductBean();
        PantryController pantryController= new PantryController();

        //prendiamo i dati e li mettiamo nella bean

        productBean.setName(nameText.getText());
        productBean.setQuantity(Integer.parseInt(quantityField.getText()));
        productBean.setTypeOfFood(typeOfFoodPicker.getValue());

        int year;
        int month;
        int day;

        year = expirationDate.getValue().getYear();
        month = expirationDate.getValue().getMonthValue();
        day = expirationDate.getValue().getDayOfMonth();

        productBean.setDay(day);
        productBean.setMonth(month);
        productBean.setYear(year);

        pantryController.addNewProduct(productBean);

        //continuare da qua: observer/ controller app
    }

    public void deleteProduct(ActionEvent actionEvent) {
    }

    public void searchProduct(ActionEvent actionEvent) {
    }

    public void showPantry(ActionEvent actionEvent) {
    }

}
