package com.example.foodo_fx.GUIclass;



import com.example.foodo_fx.model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.text.ParseException;

public class controllerGUIMainUser {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button buttonPantry;
    @FXML
    private Button addProduct;

    public controllerGUIMainUser() throws ParseException {
    }







    @FXML
    private TableColumn<Product, String> Expiration;

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
    private TextArea expirationDate;

    @FXML
    private TextArea nameText;

    @FXML
    private TextArea quantityText;

    @FXML
    private ChoiceBox<String> typePicker;

    @FXML
    private TableView<Product> tablePantry;



    private String[] typeOfFood = {"spices", "fruit", "meat", "vegetable", "sweet", "sweet", "liquid", "fish"};

    //@Override
   /* public void initialize(URL url, ResourceBundle resourceBundle){

        Name.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Product, String>("Quantity"));
        TypeOfFood.setCellValueFactory(new PropertyValueFactory<Product, String>("TypeOfFood"));
        Expiration.setCellValueFactory((new PropertyValueFactory<Product, String>("Expiration")));

        typePicker.getItems().addAll(typeOfFood);
    }
    */

    @FXML
    void addNewProduct(ActionEvent event) {
        Product product = new Product(nameText.getText(),
                quantityText.getText(), expirationDate.getText(),
                typePicker.getTypeSelector());
                ObservableList<Product> products = tablePantry.getItems();
                products.add(product);
                tablePantry.setItems(products);
    }
    @FXML
    public void showPantry(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/GUIclass/sceneMyPantry.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }


    public void showPantryUser(ActionEvent actionEvent) {
    }

    public void showProfileUser(ActionEvent actionEvent) {
    }

    public void showKitchenUser(ActionEvent actionEvent) {
    }

    public void showMyChefUser(ActionEvent actionEvent) {
    }
}