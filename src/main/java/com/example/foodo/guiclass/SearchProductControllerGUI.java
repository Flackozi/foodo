package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.dao.SearchDAO;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    public TableView<ProductModel> productTable;
    @FXML
    private    TableColumn<ProductModel, String> Name;

    @FXML
    private  TableColumn<ProductModel, Integer> Quantity;

    @FXML
    private  TableColumn<ProductModel, String> TypeOfFood;
    @FXML
    private  TableColumn<ProductModel, String> Expiration;
    private Parent scenePantryParent;


    public void showPantry(ActionEvent event) throws IOException {
        scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneMyPantry.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    public void backHome(ActionEvent event) throws IOException {
        if(Session.getCurrentSession().getChefBean() == null){
            scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        }else{
            scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        }
        Scene sceneMainView = new Scene(scenePantryParent);


        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    public void actionSearch(ActionEvent actionEvent) {
        try {
            SearchBean searchBean = new SearchBean(searchBar.getText(), spicesCheckBox.isSelected(), fruitCheckBox.isSelected(), meatCheckBox.isSelected(), vegetableCheckBox.isSelected(), sweetCheckBox.isSelected(), liquidCheckBox.isSelected(), fishCheckBox.isSelected());
            SearchProductController searchProductController = new SearchProductController();
            //ObservableList obl = FXCollections.observableArrayList(searchProductController.searchProduct(searchBean));
            productTable.getItems().clear();

            setTable(searchProductController.searchProduct(searchBean));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTable(List<ProductBean> productBeans){
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        TypeOfFood.setCellValueFactory(new PropertyValueFactory<>("TypeOfFood"));
        Expiration.setCellValueFactory(new PropertyValueFactory<>("Expiration"));

        Iterator<ProductBean> iteratorProduct=productBeans.iterator();

        ObservableList<ProductModel> obl= productTable.getItems();

        while(iteratorProduct.hasNext()) {
            ProductBean productBean = iteratorProduct.next();
            ProductModel productModel=new ProductModel(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getExpiration());
            obl.add(productModel);
        }
        productTable.setItems(obl);

    }

}



