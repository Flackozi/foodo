package com.example.foodo.engineering.Utils;

import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.model.ProductModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class TableColumns {
    public static ArrayList setcols(){
        String[] arrCols = {"Name", "Quantity", "Expiration", "TypeOfFood"};
        ArrayList tbc = new ArrayList<>();
        for(int i = 0; i < arrCols.length; i++){
            TableColumn tc = new TableColumn(arrCols[i]);
            tc.setCellValueFactory(
                    new PropertyValueFactory<ProductModel, String>(arrCols[i].toLowerCase())
            );
            tbc.add(tc);
        }
        return tbc;
    }
}
