package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.dao.ItemDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyChefController {

    public List<RecipeItemBean> retriveItem() throws SQLException, ConnectionDbException {
        List<RecipeItemBean> recipeItemBeans = new ArrayList<>();
        ItemDAO itemDAO = new ItemDAO();
        recipeItemBeans = itemDAO.getItem();

        return recipeItemBeans;
    }
}
