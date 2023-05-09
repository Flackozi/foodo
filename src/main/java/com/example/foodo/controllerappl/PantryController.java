package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PantryController {

//    private final ProductBean productBean;

//    public PantryController(ProductBean productBean){
//        this.productBean=productBean;
//    }

    public void addNewProduct (ProductBean productBean) throws SQLException {
        ProductModel productModel= new ProductModel(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getDay(), productBean.getMonth(), productBean.getYear());
//        Session.setSessionInstance(productBean);
        ProductDAO productDAO=new ProductDAO();
        productDAO.InsProduct(productModel);

    }

    public List<ProductBean> retriveAllProduct() throws SQLException, ConnectionDbException {
        List<ProductModel> productModelList = new ArrayList<>();
        List<ProductBean> productBeans = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();
        productModelList = productDAO.getAllProduct();
        int i = 0;
        int lenght = productModelList.size();
        do{
            ProductModel productModel = productModelList.get(i);
            i++;
            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpirationDay(), productModel.getExpirationMonth(), productModel.getExpirationYear());
            productBeans.add(productBean);
        }while(i != lenght);

        return productBeans;

    }

    public void deleteProduct(ProductBean productBean) throws SQLException, ConnectionDbException {

        ProductModel productModel= new ProductModel(productBean.getName());
        ProductDAO productDAO=new ProductDAO();
        productDAO.DelProduct(productModel);

    }
}