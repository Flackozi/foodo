package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.dao.ItemDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.RecipeItemModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyChefController {

    public List<RecipeBean> retriveItem() throws SQLException, ConnectionDbException {
        List<RecipeBean> recipeBeans = new ArrayList<>();
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();

        ItemDAO itemDAO = new ItemDAO();
        recipeItemModels = itemDAO.getItem();
        int i;
        int lenght =recipeItemModels.size();
        for(i=0; i<lenght; i++){
            String recipeName= recipeItemModels.get(i).getRecipeName();
            String chefName= recipeItemModels.get(i).getChefName();
            String img= recipeItemModels.get(i).getImgSrc();
            RecipeBean recipeBean= new RecipeBean(recipeName, chefName, img);
            recipeBeans.add(recipeBean);
        }
        return recipeBeans;
    }
}
