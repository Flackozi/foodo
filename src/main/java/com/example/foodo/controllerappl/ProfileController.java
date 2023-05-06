package com.example.foodo.controllerappl;

import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.userDAOJDBC;
import com.example.foodo.model.UserModel;

import java.io.IOException;

public class ProfileController {



    public UserBean getUserInfo(UserBean userBean){
        try{
            UserModel userModel = userDAOJDBC.retrieveUserByUsername(userBean.getUserUsernameBean());
            setUserInfo(userBean, userModel.getFavoriteFood(), userModel.getTypeOfDiet(), 2);
        } catch(Exception e){
            e.printStackTrace();
        }
        return userBean;
    }

    private void setUserInfo(UserBean userBean, String favoriteFood, String typeOfDiet, int userType) throws IOException {
        userBean.setUserFavoriteFoodBean(favoriteFood);
        userBean.setUserTypeOfDietBean(typeOfDiet);
        userBean.setUserProfileTypeBean(userType);
   }
}
