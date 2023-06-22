package com.example.foodo.controllerappl;

import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.SearchDAO;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.SearchModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductController {

    private String userName;
    private List<ProductBean> productBeans = new ArrayList<>();
    public List<ProductBean> searchProduct(SearchBean searchBean) throws ProductNotFoundException, SQLException, ConnectionDbException {

        String text = searchBean.getSearchText();
        Boolean spices = searchBean.getSpices();
        Boolean fruit = searchBean.getFruit();
        Boolean meat = searchBean.getMeat();
        Boolean vegetable = searchBean.getVegetable();
        Boolean sweet = searchBean.getSweet();
        Boolean liquid = searchBean.getLiquid();
        Boolean fish = searchBean.getFish();
        SearchModel searchModel = new SearchModel(text, spices, fruit, meat, vegetable, sweet, liquid, fish);

        //mi setto una variabile userName per passare il nome dell'utente alla DAO
        UserBean userBean= Session.getCurrentSession().getUserBean();
        ChefBean chefBean=Session.getCurrentSession().getChefBean();

        if(userBean!=null){
            this.userName= userBean.getUsername();
        } else{
            this.userName= chefBean.getUsername();
        }

        String type;
        if(!text.isBlank()){
            ProductModel productModel= new ProductModel();
            productModel= SearchDAO.retriveBySearchText(text);
            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
            productBeans.add(productBean);
        }
        if(Boolean.TRUE.equals(searchModel.getSpices())){
            retrieveProducts("spices");
        }

        if(Boolean.TRUE.equals(searchModel.getFruit())){
            retrieveProducts("fruit");
        }

        if(Boolean.TRUE.equals(searchModel.getMeat())){
            retrieveProducts("meat");
        }

        if(Boolean.TRUE.equals(searchModel.getVegetable())){
            retrieveProducts("vegetable");
        }

        if(Boolean.TRUE.equals(searchModel.getSweet())){
            retrieveProducts("sweet");
        }

        if(Boolean.TRUE.equals(searchModel.getLiquid())){
            retrieveProducts("liquid");
        }

        if(Boolean.TRUE.equals(searchModel.getFish())){
            retrieveProducts("fish");
        }

        if(Boolean.TRUE.equals(productBeans.isEmpty())){
            throw new ProductNotFoundException();
        }

        return productBeans;
    }

    public void retrieveProducts(String type){
        int i = 0;
        List<ProductModel> fishModels = new ArrayList<>();
        fishModels = SearchDAO.retriveByTypeOfFood(type, userName);
        for(i=0; i< fishModels.size(); i++){
            ProductModel productModel = fishModels.get(i);
            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
            productBeans.add(productBean);
            //System.out.println(productBean.getName());
        }
    }
}
