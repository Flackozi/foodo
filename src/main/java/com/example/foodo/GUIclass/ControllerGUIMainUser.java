package com.example.foodo.GUIclass;



import com.example.foodo.model.ProductModel;
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

public class ControllerGUIMainUser {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button buttonPantry;
    @FXML
    private Button addProduct;

    public ControllerGUIMainUser() throws ParseException {
    }







    @FXML
    private TableColumn<ProductModel, String> Expiration;

    @FXML
    private Button HomeButton;

    @FXML
    private TableColumn<ProductModel, String> Name;

    @FXML
    private TableColumn<ProductModel, String> Quantity;

    @FXML
    private TableColumn<ProductModel, String> TypeOfFood;

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
    private TableView<ProductModel> tablePantry;



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

//    @FXML
//    void addNewProduct(ActionEvent event) {
//        ProductModel product = new ProductModel(nameText.getText(),
//                quantityText.getText(), expirationDate.getText(),
//                typePicker.getTypeSelector());
//                ObservableList<ProductModel> products = tablePantry.getItems();
//                products.add(product);
//                tablePantry.setItems(products);
//    }
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