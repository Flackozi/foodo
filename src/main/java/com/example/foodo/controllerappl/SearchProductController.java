package com.example.foodo.controllerappl;

import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.SearchDAO;
import com.example.foodo.model.ProductModel;
import com.example.foodo.model.SearchModel;

import java.util.ArrayList;
import java.util.List;

public class SearchProductController {
    public List<ProductBean> searchProduct(SearchBean searchBean){

        String text = searchBean.getSearchText();
        Boolean spices = searchBean.getSpices();
        Boolean fruit = searchBean.getFruit();
        Boolean meat = searchBean.getMeat();
        Boolean vegetable = searchBean.getVegetable();
        Boolean sweet = searchBean.getSweet();
        Boolean liquid = searchBean.getLiquid();
        Boolean fish = searchBean.getFish();
        SearchModel searchModel = new SearchModel(text, spices, fruit, meat, vegetable, sweet, liquid, fish);
        List<ProductBean> productBeans = new ArrayList<>();
        //mi setto una variabile userName per passare il nome dell'utente alla DAO
        UserBean userBean= Session.getCurrentSession().getUserBean();
        ChefBean chefBean=Session.getCurrentSession().getChefBean();
        String userName=null;
        if(userBean!=null){
            userName= userBean.getUsername();
        } else{
            userName= chefBean.getUsername();
        }

        String type;
        if(!text.isBlank()){
            ProductModel productModel= new ProductModel();
            productModel= SearchDAO.retriveBySearchText(text);
            ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
            productBeans.add(productBean);
        }
            if(Boolean.TRUE.equals(searchModel.getSpices())){
                type = "spices";
                int i = 0;

                List<ProductModel> spicesModels = new ArrayList<>();
                spicesModels = SearchDAO.retriveByTypeOfFood(type, userName);
                int length = spicesModels.size();
                do{
                    ProductModel productModel = spicesModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }

            if(Boolean.TRUE.equals(searchModel.getFruit())){
                type = "fruit";
                int i = 0;

                List<ProductModel> fruitModels = new ArrayList<>();
                fruitModels = SearchDAO.retriveByTypeOfFood(type, userName);

                int length = fruitModels.size();
                do{
                    ProductModel productModel = fruitModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }

            if(Boolean.TRUE.equals(searchModel.getMeat())){
                int i = 0;
                type = "meat";
                List<ProductModel> meatModels = new ArrayList<>();
                meatModels = SearchDAO.retriveByTypeOfFood(type, userName);
                int length = meatModels.size();
                do{
                    ProductModel productModel = meatModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }

            if(Boolean.TRUE.equals(searchModel.getVegetable())){
                type = "vegetable";
                int i = 0;
                List<ProductModel> vegetableModels = new ArrayList<>();
                vegetableModels = SearchDAO.retriveByTypeOfFood(type, userName);
                int length = vegetableModels.size();
                do{
                    ProductModel productModel = vegetableModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }

            if(searchModel.getSweet()){
                type = "sweet";
                int i = 0;

                List<ProductModel> sweetModels = new ArrayList<>();
                sweetModels = SearchDAO.retriveByTypeOfFood(type, userName);
                int length = sweetModels.size();
                do{
                    ProductModel productModel = sweetModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }

            if(searchModel.getLiquid()){
                type = "liquid";
                int i = 0;

                List<ProductModel> liquidModels = new ArrayList<>();
                liquidModels = SearchDAO.retriveByTypeOfFood(type, userName);
                int length = liquidModels.size();
                do{
                    ProductModel productModel = liquidModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }

            if(searchModel.getFish()){
                type = "fish";
                int i = 0;
                List<ProductModel> fishModels = new ArrayList<>();
                fishModels = SearchDAO.retriveByTypeOfFood(type, userName);
                int length = fishModels.size();
                do{
                    ProductModel productModel = fishModels.get(i);
                    i++;
                    ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                    productBeans.add(productBean);
                }while(i != length);
            }



        return productBeans;
    }
}
