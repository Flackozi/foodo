package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.dao.FollowerDAO;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.dao.RecipeDAO;
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
        for(i=0; i< productModelList.size(); i++){
            String ingName=productModelList.get(i).getName();
            String quantity= productModelList.get(i).getQuantity();
            ProductBean productBean= new ProductBean(ingName, quantity);
            productBeans.add(productBean);
        }
        return productBeans;
    }

    public String getDescription(String rname) {
        RecipeDAO recipeDAO = new RecipeDAO();
        return recipeDAO.retriveDescription(rname);
    }

    public void setRate(int value, String name) {
        RecipeDAO recipeDAO = new RecipeDAO();
        recipeDAO.setReview(value, name);
    }

    public String getPath(String rname) {
        RecipeDAO recipeDAO= new RecipeDAO();
        return recipeDAO.retrivePath(rname);
    }

    public int verifyFollow(String userName, String chefName) {
        FollowerDAO followerDAO= new FollowerDAO();
        int followed= followerDAO.checkFollow(userName, chefName);
        if(followed==0){
            followerDAO.unfollowChef(userName, chefName);
        }else{
            followerDAO.followChef(userName, chefName);
        }
        return followed;
    }

    public String setAverage(String rname, String chefName) {
        RecipeDAO recipeDAO= new RecipeDAO();
        return String.valueOf(recipeDAO.setAverage(rname, chefName));

    }

    public void deleteRecipe(String recipeName, String chefName) {
        RecipeDAO recipeDAO= new RecipeDAO();
        recipeDAO.deleteRecipe(recipeName, chefName);
    }
}
