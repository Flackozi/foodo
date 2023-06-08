package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.graphic.viewcli.AddProductCLIView;

import java.sql.SQLException;

public class AddProductCLIController implements GrapghiCLIController{
    private AddProductCLIView addProductCLIView;

    @Override
    public void start() {
        this.addProductCLIView= new AddProductCLIView(this);
        this.addProductCLIView.run();
    }

    public void addProduct(String name, int quantity, String typeOfFood, String expiration, String expDay, String expMonth, String expYear) throws SQLException {
        ProductBean productBean= new ProductBean();
        productBean.setName(name);
        productBean.setQuantity(quantity);
        productBean.setTypeOfFood(typeOfFood);
        productBean.setDay(Integer.parseInt(expDay));
        productBean.setMonth(Integer.parseInt(expMonth));
        productBean.setYear(Integer.parseInt(expYear));
        productBean.setExpiration(expiration);
        PantryController pantryController= new PantryController();
        pantryController.addNewProduct(productBean);
    }
}
