package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.dao.ItemDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.RecipeItemModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyRecipeController {

    public List<RecipeItemBean> retriveRecipeItem() throws SQLException, ConnectionDbException {
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();
        List<RecipeItemBean> recipeItemBeanList = new ArrayList<>();

        ItemDAO itemDAO = new ItemDAO();
        recipeItemModels = itemDAO.getRecipeItem();
        int i;
        int lenght =recipeItemModels.size();
        for(i=0; i<lenght; i++){
            String recipeName= recipeItemModels.get(i).getRecipeName();
            String chefName= recipeItemModels.get(i).getChefName();
            String img= recipeItemModels.get(i).getImgSrc();
            RecipeItemBean recipeItemBean= new RecipeItemBean(recipeName, chefName, img);
            recipeItemBeanList.add(recipeItemBean);
        }

        return recipeItemBeanList;
    }
}
