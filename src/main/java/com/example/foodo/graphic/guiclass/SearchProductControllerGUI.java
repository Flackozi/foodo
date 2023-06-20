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
            SearchBean searchBean = new SearchBean();

            searchBean.setSearchText(searchBean.getSearchText());
            searchBean.setSpices(spicesCheckBox.isSelected());
            searchBean.setFruit(fruitCheckBox.isSelected());
            searchBean.setMeat(meatCheckBox.isSelected());
            searchBean.setSweet(sweetCheckBox.isSelected());
            searchBean.setVegetable(vegetableCheckBox.isSelected());
            searchBean.setFish(fishCheckBox.isSelected());
            searchBean.setLiquid(liquidCheckBox.isSelected());
            SearchProductController searchProductController = new SearchProductController();
            //ObservableList obl = FXCollections.observableArrayList(searchProductController.searchProduct(searchBean));
            productTable.getItems().clear();
            if(searchProductController.searchProduct(searchBean) != null){
                setTable(searchProductController.searchProduct(searchBean));
            }else{
                throw new ProductNotFoundException();
            }


        } catch (ProductNotFoundException e) {
            ExceptionController.showExceptionGUI(e.getMessage());
        } catch (SQLException | ConnectionDbException e) {
            throw new RuntimeException(e);
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



