package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
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
        SearchDAO searchDAO = new SearchDAO();
        List<ProductBean> productBeans = new ArrayList<>();

        String type;
        if(searchModel.getSpices() == true){
            type = "spices";
            int i = 0;

            List<ProductModel> spicesModels = new ArrayList<>();
            spicesModels = searchDAO.retriveByTypeOfFood(type);
            int length = spicesModels.size();
            do{
                ProductModel productModel = spicesModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpirationDay(), productModel.getExpirationMonth(), productModel.getExpirationYear());
                productBeans.add(productBean);
            }while(i != length);
        }

        if(searchModel.getFruit() == true){
            type = "fruit";
            int i = 0;

            List<ProductModel> fruitModels = new ArrayList<>();
            fruitModels = searchDAO.retriveByTypeOfFood(type);
            int length = fruitModels.size();
            do{
                ProductModel productModel = fruitModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpirationDay(), productModel.getExpirationMonth(), productModel.getExpirationYear());
                productBeans.add(productBean);
            }while(i != length);
        }

        if(searchModel.getMeat() == true){
            int i = 0;
            type = "meat";
            List<ProductModel> meatModels = new ArrayList<>();
            meatModels = searchDAO.retriveByTypeOfFood(type);
            int length = meatModels.size();
            do{
                ProductModel productModel = meatModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                productBeans.add(productBean);
            }while(i != length);
        }

        if(searchModel.getVegetable() == true){
            type = "vegetable";
            int i = 0;
            List<ProductModel> vegetableModels = new ArrayList<>();
            vegetableModels = searchDAO.retriveByTypeOfFood(type);
            int length = vegetableModels.size();
            do{
                ProductModel productModel = vegetableModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpiration());
                productBeans.add(productBean);
            }while(i != length);
        }

        if(searchModel.getSweet() == true){
            type = "sweet";
            int i = 0;

            List<ProductModel> sweetModels = new ArrayList<>();
            sweetModels = searchDAO.retriveByTypeOfFood(type);
            int length = sweetModels.size();
            do{
                ProductModel productModel = sweetModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpirationDay(), productModel.getExpirationMonth(), productModel.getExpirationYear());
                productBeans.add(productBean);
            }while(i != length);
        }

        if(searchModel.getLiquid() == true){
            type = "liquid";
            int i = 0;

            List<ProductModel> liquidModels = new ArrayList<>();
            liquidModels = searchDAO.retriveByTypeOfFood(type);
            int length = liquidModels.size();
            do{
                ProductModel productModel = liquidModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpirationDay(), productModel.getExpirationMonth(), productModel.getExpirationYear());
                productBeans.add(productBean);
            }while(i != length);
        }

        if(searchModel.getFish() == true){
            type = "fish";
            int i = 0;
            List<ProductModel> fishModels = new ArrayList<>();
            fishModels = searchDAO.retriveByTypeOfFood(type);
            int length = fishModels.size();
            do{
                ProductModel productModel = fishModels.get(i);
                i++;
                ProductBean productBean = new ProductBean(productModel.getName(), productModel.getQuantity(), productModel.getTypeOfFood(), productModel.getExpirationDay(), productModel.getExpirationMonth(), productModel.getExpirationYear());
                productBeans.add(productBean);
            }while(i != length);
        }
        return productBeans;
    }
}
