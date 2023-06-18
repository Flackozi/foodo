package com.example.foodo.engineering.session;

import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.UserBean;

public class Session {

    private static Session sessionInstance=null;
    private UserBean userBean;
    private ChefBean chefBean;
    private ProductBean productBean;

    private Session (Object ob){
        if(ob instanceof UserBean){
            this.userBean= (UserBean) ob;
        }
        else if(ob instanceof ChefBean){
            chefBean=(ChefBean) ob;
        }
    }

    public static void setSessionInstance(Object ob){
        if(sessionInstance==null)
            sessionInstance=new Session(ob);
    }

    public static void closeSession() {
        sessionInstance = null;
    }

    public static Session getCurrentSession() {
        return sessionInstance;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public ChefBean getChefBean() {
        return chefBean;
    }
    public ProductBean getProductBean(){return productBean;}

}
