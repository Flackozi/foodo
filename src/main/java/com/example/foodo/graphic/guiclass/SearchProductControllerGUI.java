package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.model.ProductModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class SearchProductControllerGUI {
    @FXML
    private Button buttonSearchProduct;
    @FXML
    private TextField searchBar;
    @FXML
    private CheckBox spicesCheckBox;
    @FXML
    private CheckBox fruitCheckBox;
    @FXML
    private CheckBox meatCheckBox;
    @FXML
    private CheckBox vegetableCheckBox;
    @FXML
    private CheckBox sweetCheckBox;
    @FXML
    private CheckBox liquidCheckBox;
    @FXML
    private CheckBox fishCheckBox;
    @FXML
    private TableView<ProductModel> productTable;
    @FXML
    private    TableColumn<ProductModel, String> name;

    @FXML
    private  TableColumn<ProductModel, Integer> quantity;

    @FXML
    private  TableColumn<ProductModel, String> typeOfFood;
    @FXML
    private  TableColumn<ProductModel, String> expiration;
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
    public void actionSearch() {
        try {
            SearchBean searchBean = new SearchBean();

            searchBean.setSearchText(searchBar.getText());
            searchBean.setSpices(spicesCheckBox.isSelected());
            searchBean.setFruit(fruitCheckBox.isSelected());
            searchBean.setMeat(meatCheckBox.isSelected());
            searchBean.setSweet(sweetCheckBox.isSelected());
            searchBean.setVegetable(vegetableCheckBox.isSelected());
            searchBean.setFish(fishCheckBox.isSelected());
            searchBean.setLiquid(liquidCheckBox.isSelected());
            SearchProductController searchProductController = new SearchProductController();
            productTable.getItems().clear();
            if(searchProductController.searchProduct(searchBean) != null){
                setTable(searchProductController.searchProduct(searchBean));
            }else{
                throw new ProductNotFoundException();
            }
        } catch (SQLException | ConnectionDbException | ProductNotFoundException e) {
            ExceptionController.showExceptionGUI(e.getMessage());
        }
    }

    private void setTable(List<ProductBean> productBeans){
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        typeOfFood.setCellValueFactory(new PropertyValueFactory<>("TypeOfFood"));
        expiration.setCellValueFactory(new PropertyValueFactory<>("Expiration"));

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



