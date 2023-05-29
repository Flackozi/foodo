package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDetController {
    public List<ProductBean> getRecipeIngredients(String name) throws SQLException, ConnectionDbException {
        List<ProductModel> productModelList = new ArrayList<>();
        List<ProductBean> productBeans = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();
        productModelList = productDAO.getRecipeIng(name);
        int i ;
//        while(productModelList.isEmpty()){
//            ProductModel productModel = productModelList.get(i);
//            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getquantity());
//            productBeans.add(productBean);
//        }
        for(i=0; i< productModelList.size(); i++){
            String IngName=productModelList.get(i).getName();
            String Quantity= productModelList.get(i).getSquantity();
            ProductBean productBean= new ProductBean(IngName, Quantity);
            productBeans.add(productBean);
        }
        return productBeans;
    }
}
