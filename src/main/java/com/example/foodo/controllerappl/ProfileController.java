package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.ChefDAO;
import com.example.foodo.engineering.dao.userDAOJDBC;
import com.example.foodo.model.ChefModel;
import com.example.foodo.model.UserModel;

import java.io.File;
import java.io.IOException;

public class ProfileController {



    public UserBean getUserInfo(UserBean userBean){
        try{
            UserModel userModel = userDAOJDBC.retrieveUserByUsername(userBean.getUserUsernameBean());
            setUserInfo(userBean, userModel.getFavoriteFood(), userModel.getTypeOfDiet(), userModel.getPath(), 2);
        } catch(Exception e){
            e.printStackTrace();
        }
        return userBean;
    }

    public ChefBean getChefInfo(ChefBean chefBean){
        try{
            ChefModel chefModel = ChefDAO.retrieveChefByUsername(chefBean.getUsername());
            setChefInfo(chefBean, chefModel.getTypeOfCuisine(), chefModel.getWorkplace(), chefModel.getEmail(), chefModel.getNumber(), chefModel.getLocation(), chefModel.getPath(),1);

        } catch(Exception e){
            e.printStackTrace();
        }
        return chefBean;
    }

    private void setUserInfo(UserBean userBean, String favoriteFood, String typeOfDiet, String path, int userType) throws IOException {
        userBean.setUserFavoriteFoodBean(favoriteFood);
        userBean.setUserTypeOfDietBean(typeOfDiet);
        userBean.setUserProfileTypeBean(userType);
        userBean.setPath(path);
   }

    public void setImage(UserBean userBean) {
        userDAOJDBC.updateImage(userBean.getPath(), userBean.getUserUsernameBean());

    }

    public void setChefImage(ChefBean chefBean) {
        ChefDAO.updateImage(chefBean.getPath(), chefBean.getUsername());

    }

    private void setChefInfo(ChefBean chefBean , String typeOfCuisine, String workplace, String email, String number, String location, String path, int userType) throws IOException {
        chefBean.setTypeOfCuisine(typeOfCuisine);
        chefBean.setWorkplace(workplace);
        chefBean.setEmail(email);
        chefBean.setNumber(number);
        chefBean.setLocation(location);
        chefBean.setPath(path);

    }
}
