package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.bean.SearchBean;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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


    public void showPantry(ActionEvent actionEvent) {
    }

    public void actionSearch(ActionEvent actionEvent) {
        SearchBean searchBean = new SearchBean(searchBar.getText(), spicesCheckBox.isSelected(), fruitCheckBox.isSelected(), meatCheckBox.isSelected(), vegetableCheckBox.isSelected(), sweetCheckBox.isSelected(), liquidCheckBox.isSelected(), fishCheckBox.isSelected());
        SearchProductController searchProductController = new SearchProductController();
        searchProductController.searchProduct;
    }
}
