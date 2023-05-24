package com.example.foodo.engineering.dao;

import com.example.foodo.engineering.Session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.connection.ConnectionDB;
import com.example.foodo.engineering.dao.queries.BasicQueries;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ChefModel;
import com.example.foodo.model.RecipeItemModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public List<RecipeItemModel> getItem() throws ConnectionDbException, SQLException {
        Statement stmt;
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();


        stmt = ConnectionDB.getConnection();
        UserBean userBean = Session.getCurrentSession().getUserBean();

        String userName = userBean.getUserUsernameBean();
        ResultSet resultSet = BasicQueries.retriveFavoriteChef(stmt, userName);
        resultSet.next();
        resultSet.first();
        List<String> chefNames = new ArrayList<>();
        int i = 0;
        do{
            String chefName = resultSet.getString("chefName");
            //ChefModel chefModel = new ChefModel(chefName);
            chefNames.add(chefName);

        }while(resultSet.next());

        for(i=0; i<chefNames.size(); i++){
            String name = chefNames.get(i);
            ResultSet resultSet1 = BasicQueries.retriveItem(stmt, name);
            int j = 0;
            while(resultSet1.next()){
                String nameR = resultSet1.getString("recipeName");
                String nameC = resultSet1.getString("chefName");
                String img = resultSet1.getString("image");
                RecipeItemModel recipeItemModel = new RecipeItemModel(nameR, nameC, img);
                recipeItemModels.add(recipeItemModel);
            }

        }

        return recipeItemModels;
    }

    public List<RecipeItemModel> getRecipeItem() throws ConnectionDbException, SQLException{
        Statement stmt;
        List<RecipeItemModel> recipeItemModels = new ArrayList<>();


        stmt = ConnectionDB.getConnection();
        ChefBean chefBean = Session.getCurrentSession().getChefBean();

        String chefName = chefBean.getUsername();
        ResultSet resultSet1 = BasicQueries.retriveItem(stmt, chefName);
        int j = 0;
        while(resultSet1.next()){
            String nameR = resultSet1.getString("recipeName");
            String nameC = resultSet1.getString("chefName");
            String img = resultSet1.getString("image");
            RecipeItemModel recipeItemModel = new RecipeItemModel(nameR, nameC, img);
            recipeItemModels.add(recipeItemModel);
        }

        return recipeItemModels;
    }
}
