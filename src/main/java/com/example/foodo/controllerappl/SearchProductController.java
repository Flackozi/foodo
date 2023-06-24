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


    public List<ProductBean> searchProduct(SearchBean searchBean) throws ProductNotFoundException, SQLException, ConnectionDbException {

        String text = searchBean.getSearchText();
        Boolean spices = searchBean.getSpices();
        Boolean fruit = searchBean.getFruit();
        Boolean meat = searchBean.getMeat();
        Boolean vegetable = searchBean.getVegetable();
        Boolean sweet = searchBean.getSweet();
        Boolean liquid = searchBean.getLiquid();
        Boolean fish = searchBean.getFish();
        SearchModel searchModel = new SearchModel();
        searchModel.setSearchText(text);
        searchModel.setSpices(spices);
        searchModel.setFruit(fruit);
        searchModel.setMeat(meat);
        searchModel.setVegetable(vegetable);
        searchModel.setSweet(sweet);
        searchModel.setLiquid(liquid);
        searchModel.setFish(fish);
        List<ProductBean> productBeans = new ArrayList<>();
        //mi setto una variabile userName per passare il nome dell'utente alla DAO
        UserBean userBean= Session.getCurrentSession().getUserBean();
        ChefBean chefBean=Session.getCurrentSession().getChefBean();

        if(userBean!=null){
            userName= userBean.getUsername();
        } else{
            userName= chefBean.getUsername();
        }

        if(!text.isBlank()){
            ProductModel productModel= new ProductModel();
            productModel= SearchDAO.retriveBySearchText(text);
            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
            productBeans.add(productBean);
        }
        if(Boolean.TRUE.equals(searchModel.getSpices())){
            productBeans.addAll(retrieveProducts("spices"));

        }

        if(Boolean.TRUE.equals(searchModel.getFruit())){
            productBeans.addAll(retrieveProducts("fruit"));
        }

        if(Boolean.TRUE.equals(searchModel.getMeat())){
            productBeans.addAll(retrieveProducts("meat"));
        }

        if(Boolean.TRUE.equals(searchModel.getVegetable())){
            productBeans.addAll(retrieveProducts("vegetable"));
        }

        if(Boolean.TRUE.equals(searchModel.getSweet())){
            productBeans.addAll(retrieveProducts("sweet"));
        }

        if(Boolean.TRUE.equals(searchModel.getLiquid())){
            productBeans.addAll(retrieveProducts("liquid"));
        }

        if(Boolean.TRUE.equals(searchModel.getFish())){
            productBeans.addAll(retrieveProducts("fish"));
        }

        if(Boolean.TRUE.equals(productBeans.isEmpty())){
            throw new ProductNotFoundException();
        }

        return productBeans;
    }

    public List<ProductBean> retrieveProducts(String type) throws SQLException {
        int i = 0;
        List<ProductModel> productModels = new ArrayList<>();
        List<ProductBean> productBeanList=new ArrayList<>();
        productModels = SearchDAO.retriveByTypeOfFood(type, userName);
        for(i=0; i< productModels.size(); i++){
            ProductBean productBean = new ProductBean(productModels.get(i).getName(), productModels.get(i).getQuantity(), productModels.get(i).getTypeOfFood(), productModels.get(i).getExpiration());
            productBeanList.add(productBean);
        }
        return productBeanList;
    }
}
