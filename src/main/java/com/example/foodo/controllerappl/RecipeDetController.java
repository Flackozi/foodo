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
        //System.out.print(name);
        productModelList = productDAO.getRecipeIng(name);
        int i =0;
        while(productModelList.isEmpty()){
            ProductModel productModel = productModelList.get(i);
            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity());
            productBeans.add(productBean);
        }
        return productBeans;
    }
}
