package com.example.foodo.guiclass;
import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.Utils.ExceptionControllerGUI;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.DateFormatException;
import com.example.foodo.engineering.exception.UserNotFoundException;
import com.example.foodo.engineering.exception.CommandErrorException;
import com.example.foodo.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import com.example.foodo.engineering.exception.*;

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
    private DatePicker expirationDate;

    @FXML
    private TextField nameText;

    @FXML
    private TextField quantityField;

    @FXML
    private ChoiceBox<String> typeOfFoodPicker;

    @FXML
    private TableView tablePantry;


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

    private String[] typeOfFood = {"spices", "fruit", "meat", "vegetable", "sweet", "liquid", "fish", "other"};
private ProductDAO productDAO = new ProductDAO();
    public void initialize(URL url, ResourceBundle resourceBundle){
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Expiration.setCellValueFactory(new PropertyValueFactory<>("Expiration"));
        TypeOfFood.setCellValueFactory(new PropertyValueFactory<>("TypeOfFood"));

        typeOfFoodPicker.getItems().addAll(typeOfFood);
        typeOfFoodPicker.setOnAction(this::getType);
        try{
            PantryController pantryController = new PantryController();
            List<ProductBean> productBeans = new ArrayList<>();
            productBeans = pantryController.retriveAllProduct();
            tablePantry.getItems().clear();
            Iterator<ProductBean> iteratorProduct= productBeans.iterator();
            ObservableList<ProductModel> obl = tablePantry.getItems();
            while(iteratorProduct.hasNext()) {
                ProductBean productBean = iteratorProduct.next();
                ProductModel productModel=new ProductModel(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getExpiration());

                obl.add(productModel);
            }

            tablePantry.setItems(obl);
//            tablePantry.setItems(productDAO.getAllProduct());

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void getType(ActionEvent event){
        String myType = typeOfFoodPicker.getValue();
    }
    public void addNewProduct(ActionEvent actionEvent) throws  IOException{


        //prendiamo i dati e li mettiamo nella bean
        try {
            ProductBean productBean = new ProductBean();
            PantryController pantryController = new PantryController();
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

            String exp = day + "/" + month + "/" + year;

            ProductModel product = new ProductModel(nameText.getText(), Integer.parseInt(quantityField.getText()), typeOfFoodPicker.getValue(), exp);
            tablePantry.getItems().add(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public void deleteProduct(ActionEvent actionEvent) throws SQLException, ConnectionDbException {
        int year;
        int month;
        int day;

        PantryController pantryController= new PantryController();


        ObservableList<ProductModel> allProduct, SingleProduct;
        allProduct=tablePantry.getItems();
        SingleProduct=tablePantry.getSelectionModel().getSelectedItems();
        String Name= SingleProduct.get(0).getName();
        SingleProduct.forEach(allProduct::remove);

//        String date= SingleProduct.get(0).getExpiration();

//        int Quantity=SingleProduct.get(0).getQuantity();
//        String TypeOfFood=SingleProduct.get(0).getTypeOfFood();
//
//        day=Integer.parseInt(String.valueOf(date.charAt(0)+date.charAt(1)));
//        month=Integer.parseInt(String.valueOf(date.charAt(3)+date.charAt(4)));
//        year=Integer.parseInt(String.valueOf(date.charAt(6)+date.charAt(7)+date.charAt(8)+date.charAt(9)));


        ProductBean productBean = new ProductBean(Name);

        pantryController.deleteProduct(productBean);


    }



    public void showPantry(ActionEvent actionEvent) {
    }

}
