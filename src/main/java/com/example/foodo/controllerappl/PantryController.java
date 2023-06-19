package com.example.foodo.controllerappl;

import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PantryController {


    public void addNewProduct (ProductBean productBean) throws SQLException {

        productBean.notifyObservers(productBean);
        ProductModel productModel= new ProductModel(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getDay(), productBean.getMonth(), productBean.getYear());
        UserBean userBean= Session.getCurrentSession().getUserBean();
        ChefBean chefBean=Session.getCurrentSession().getChefBean();
        if(userBean!=null){
            ProductDAO.InsProduct(productModel, userBean.getUsername());
        } else if (chefBean!=null) {
            ProductDAO.InsProduct(productModel, chefBean.getUsername());
        }


    }

    public List<ProductBean> retriveAllProduct() throws SQLException, ConnectionDbException {
        List<ProductModel> productModelList = new ArrayList<>();
        List<ProductBean> productBeans = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();
        UserBean userBean= Session.getCurrentSession().getUserBean();
        ChefBean chefBean=Session.getCurrentSession().getChefBean();
        if(userBean!=null){
            productModelList = productDAO.getAllProduct(userBean.getUsername());
        } else if (chefBean!=null) {
            productModelList = productDAO.getAllProduct(chefBean.getUsername());
        }
        int i = 0;
        int lenght = productModelList.size();

        for(i=0; i<lenght; i++){
            String name= productModelList.get(i).getName();
            String quantity= productModelList.get(i).getQuantity();
            String type= productModelList.get(i).getTypeOfFood();
            String expiration= productModelList.get(i).getExpiration();
            ProductBean productBean= new ProductBean(name, quantity, type, expiration);
            productBeans.add(productBean);
        }

        return productBeans;

    }

    public void deleteProduct(ProductBean productBean) throws SQLException, ConnectionDbException {

        ProductModel productModel= new ProductModel(productBean.getName());
        ProductDAO productDAO=new ProductDAO();
        UserBean userBean= Session.getCurrentSession().getUserBean();
        ChefBean chefBean=Session.getCurrentSession().getChefBean();
        if(userBean!=null){
            productDAO.DelProduct(productModel, userBean.getUsername());
        } else if (chefBean!=null) {
            productDAO.DelProduct(productModel, chefBean.getUsername());
        }

    }
}
