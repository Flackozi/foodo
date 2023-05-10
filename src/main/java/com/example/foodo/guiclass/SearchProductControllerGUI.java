package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.dao.SearchDAO;
import com.example.foodo.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchProductControllerGUI {
    public Button buttonSearchProduct;
    public TextField searchBar;
    public CheckBox spicesCheckBox;
    public CheckBox fruitCheckBox;
    public CheckBox meatCheckBox;
    public CheckBox vegetableCheckBox;
    public CheckBox sweetCheckBox;
    public CheckBox liquidCheckBox;
    public CheckBox fishCheckBox;
    public TableView productTable;
    @FXML
    public  TableColumn<ProductModel, String> Name;

    @FXML
    public  TableColumn<ProductModel, Integer> Quantity;

    @FXML
    public  TableColumn<ProductModel, String> TypeOfFood;
    @FXML
    public  TableColumn<ProductModel, DatePicker> Expiration;



    public void showPantry(ActionEvent actionEvent) {
    }
    public void actionSearch(ActionEvent actionEvent) {
        try{
            SearchBean searchBean = new SearchBean(searchBar.getText(), spicesCheckBox.isSelected(), fruitCheckBox.isSelected(), meatCheckBox.isSelected(), vegetableCheckBox.isSelected(), sweetCheckBox.isSelected(), liquidCheckBox.isSelected(), fishCheckBox.isSelected());
            SearchProductController searchProductController = new SearchProductController();
            ObservableList obl = FXCollections.observableArrayList(searchProductController.searchProduct(searchBean));
            Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            Expiration.setCellValueFactory(new PropertyValueFactory<>("Expiration"));
            TypeOfFood.setCellValueFactory(new PropertyValueFactory<>("TypeOfFood"));
            productTable.setItems(obl);
        }catch(Exception e){
            e.printStackTrace();
        }



    }


}
