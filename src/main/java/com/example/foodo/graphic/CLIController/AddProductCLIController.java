package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.DateFormatNotValidException;
import com.example.foodo.graphic.viewcli.AddProductViewCLI;

import java.sql.DataTruncation;
import java.sql.SQLException;

public class AddProductCLIController implements GrapghiCLIController{
    private AddProductViewCLI addProductViewCLI;

    @Override
    public void start() {
        this.addProductViewCLI = new AddProductViewCLI(this);
        this.addProductViewCLI.run();
    }

    public void addProduct(String name, String quantity, String typeOfFood, String expiration, String expDay, String expMonth, String expYear) throws SQLException, DateFormatNotValidException {
        ProductBean productBean= new ProductBean();
        productBean.setName(name);
        productBean.setQuantity(quantity);
        productBean.setTypeOfFood(typeOfFood);
        if((Integer.parseInt(expDay) > 31) && (Integer.parseInt(expDay) < 1)){
            throw new DateFormatNotValidException();
        }
        productBean.setDay(Integer.parseInt(expDay));
        if((Integer.parseInt(expMonth) > 12) && (Integer.parseInt(expMonth) < 1)){
            throw new DateFormatNotValidException();
        }
        productBean.setMonth(Integer.parseInt(expMonth));
        if(Integer.parseInt(expYear) < 2023){
            throw new DateFormatNotValidException();
        }
        productBean.setYear(Integer.parseInt(expYear));
        productBean.setExpiration(expiration);
        PantryController pantryController= new PantryController();
        pantryController.addNewProduct(productBean);
    }
}
