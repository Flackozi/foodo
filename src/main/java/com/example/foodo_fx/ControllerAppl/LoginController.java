package com.example.foodo_fx.ControllerAppl;

import com.example.foodo_fx.engineering.Session.Session;
import com.example.foodo_fx.engineering.bean.ChefBean;
import com.example.foodo_fx.engineering.bean.LoginBean;
import com.example.foodo_fx.engineering.bean.UserBean;
import com.example.foodo_fx.engineering.dao.LoginDAO;
import com.example.foodo_fx.engineering.dao.userDAOJDBC;
import com.example.foodo_fx.engineering.dao.chefDAO;
import com.example.foodo_fx.engineering.exception.NotFoundException;
import com.example.foodo_fx.model.UserModel;
import com.example.foodo_fx.model.ChefModel;


public class LoginController {
    public void checkLogin(LoginBean loginBean) {
        int type = LoginDAO.loginCheck(loginBean.getUsername(), loginBean.getPassword());
        loginBean.setAccountType(type);
    }



    public void completeChefLogin(LoginBean loginBean) throws NotFoundException {
        ChefModel chefModel = chefDAO.retrieveChefByUsername(loginBean.getUsername());
        ChefBean chefBean = new ChefBean(chefModel.getUsername(), chefModel.getTypeOfCuisine(), chefModel.getWorkplace(), chefModel.getProfileType());
        Session.setSessionInstance(chefBean);
    }

    public void completeUserLogin(LoginBean loginBean) throws NotFoundException{
        userDAOJDBC userDAO=new userDAOJDBC();
        UserModel userModel = userDAO.retrieveUserByUsername(loginBean.getUsername());
        UserBean userBean = new UserBean(userModel.getUsername(), userModel.getFavoriteFood(), userModel.getTypeOfDiet(), userModel.getProfileType());
        Session.setSessionInstance(userBean);
    }
}
