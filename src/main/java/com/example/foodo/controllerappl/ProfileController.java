package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.ChefDAO;
import com.example.foodo.engineering.dao.UserDAO;
import com.example.foodo.engineering.pattern.factory.ChefDAOFactory;
import com.example.foodo.engineering.pattern.factory.UserDAOFactory;
import com.example.foodo.model.ChefModel;
import com.example.foodo.model.UserModel;

public class ProfileController {



    public UserBean getUserInfo(UserBean userBean){
        try{
            UserDAO userDAO = UserDAOFactory.getInstance().getUserDAO();
            UserModel userModel = userDAO.retrieveUserByUsername(userBean.getUsername());
            setUserInfo(userBean, userModel.getFavoriteFood(), userModel.getTypeOfDiet(), userModel.getPath(), 2);
        } catch(Exception e){
            e.printStackTrace();
        }
        return userBean;
    }

    public ChefBean getChefInfo(ChefBean chefBean){
        try{
            ChefDAO chefDAO= ChefDAOFactory.getInstance().getChefDAO();
            ChefModel chefModel = chefDAO.retrieveChefByUsername(chefBean.getUsername());
            setChefInfo(chefBean, chefModel.getTypeOfCuisine(), chefModel.getWorkplace(), chefModel.getEmail(), chefModel.getNumber(), chefModel.getLocation(), chefModel.getPath());

        } catch(Exception e){
            e.printStackTrace();
        }
        return chefBean;
    }

    private void setUserInfo(UserBean userBean, String favoriteFood, String typeOfDiet, String path, int userType){
        userBean.setUserFavoriteFoodBean(favoriteFood);
        userBean.setUserTypeOfDietBean(typeOfDiet);
        userBean.setUserProfileTypeBean(userType);
        userBean.setPath(path);
   }




    private void setChefInfo(ChefBean chefBean , String typeOfCuisine, String workplace, String email, String number, String location, String path) {
        chefBean.setTypeOfCuisine(typeOfCuisine);
        chefBean.setWorkplace(workplace);
        chefBean.setEmail(email);
        chefBean.setNumber(number);
        chefBean.setLocation(location);
        chefBean.setPath(path);

    }
}
