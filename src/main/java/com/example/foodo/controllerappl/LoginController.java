package com.example.foodo.controllerappl;

import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.LoginBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.ChefDAO;
import com.example.foodo.engineering.dao.LoginDAO;
import com.example.foodo.engineering.dao.UserDAO;
import com.example.foodo.engineering.pattern.factory.ChefDAOFactory;
import com.example.foodo.engineering.pattern.factory.UserDAOFactory;
import com.example.foodo.model.UserModel;
import com.example.foodo.model.ChefModel;


public class LoginController {
    public void checkLogin(LoginBean loginBean) {
        int type = LoginDAO.loginCheck(loginBean.getUsername(), loginBean.getPassword());
        loginBean.setAccountType(type);
    }



    public void completeChefLogin(LoginBean loginBean){
        ChefDAO chefDAO = ChefDAOFactory.getInstance().getChefDAO();
        ChefModel chefModel = chefDAO.retrieveChefByUsername(loginBean.getUsername());
        ChefBean chefBean = new ChefBean();
        chefBean.setUsername(chefModel.getUsername());
        chefBean.setTypeOfCuisine(chefModel.getTypeOfCuisine());
        chefBean.setWorkplace(chefModel.getWorkplace());
        chefBean.setProfileType(chefModel.getProfileType());
        chefBean.setEmail(chefModel.getEmail());
        chefBean.setNumber(chefModel.getNumber());
        chefBean.setLocation(chefModel.getLocation());
        chefBean.setPath(chefModel.getPath());
        Session.setSessionInstance(chefBean);
    }

    public void completeUserLogin(LoginBean loginBean){
        UserDAO userDAO= UserDAOFactory.getInstance().getUserDAO();
        UserModel userModel = userDAO.retrieveUserByUsername(loginBean.getUsername());
        UserBean userBean = new UserBean(userModel.getUsername(), userModel.getFavoriteFood(), userModel.getTypeOfDiet(), userModel.getProfileType(), userModel.getPath());
        Session.setSessionInstance(userBean);


    }
}
