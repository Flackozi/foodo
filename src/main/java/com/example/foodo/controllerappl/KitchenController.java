package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.KitchenBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.dao.KitchenDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.KitchenModel;
import com.example.foodo.model.RecipeModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KitchenController {
    public List<RecipeItemBean> searchRecipe(KitchenBean kitchenBean) throws ConnectionDbException, SQLException {
        KitchenModel kitchenModel= new KitchenModel(kitchenBean.getIngredient1(), kitchenBean.getIngredient2(), kitchenBean.getIngredient3(), kitchenBean.getIngredient4(), kitchenBean.getIngredient5());
        List<RecipeItemBean> recipeItemBeans= new ArrayList<>();
        List<RecipeModel> recipeModels=new ArrayList<>();
        KitchenDAO kitchenDAO= new KitchenDAO();
        recipeModels=kitchenDAO.searchProduct(kitchenModel);
        int i;
        int lenght =recipeModels.size();
        for(i=0; i<lenght; i++){
            RecipeItemBean recipeItemBean= new RecipeItemBean(recipeModels.get(i).getRecipeName(), recipeModels.get(i).getChefName(), recipeModels.get(i).getPath());
            recipeItemBeans.add(recipeItemBean);
        }

        return recipeItemBeans;
    }
}
