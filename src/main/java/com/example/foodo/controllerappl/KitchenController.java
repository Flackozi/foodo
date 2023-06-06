package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.KitchenBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.dao.KitchenDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.KitchenModel;
import com.example.foodo.model.RecipeModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitchenController {
    public List<RecipeBean> searchRecipe(KitchenBean kitchenBean) throws ConnectionDbException, SQLException {
        KitchenModel kitchenModel= new KitchenModel(kitchenBean.getIngredient1(), kitchenBean.getIngredient2(), kitchenBean.getIngredient3(), kitchenBean.getIngredient4(), kitchenBean.getIngredient5());
        List<RecipeBean> recipeBeans= new ArrayList<>();
        List<RecipeModel> recipeModels=new ArrayList<>();
        KitchenDAO kitchenDAO= new KitchenDAO();
        recipeModels=kitchenDAO.searchProduct(kitchenModel);
        int i;
        int lenght =recipeModels.size();
        for(i=0; i<lenght; i++){
            RecipeBean recipeBean= new RecipeBean(recipeModels.get(i).getRecipeName(), recipeModels.get(i).getChefName(), recipeModels.get(i).getPath());
            recipeBeans.add(recipeBean);
        }

        return recipeBeans;
    }
}
