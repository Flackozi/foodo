package com.example.foodo_fx.engineering.bean;

public class LoginBean {
    private String password;
    private String username;
    private int accountType; //2->basic User, 1->Chef User

    public LoginBean(){}

    public LoginBean(String username, String password){
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public int getAccountType(){
        return accountType;
    }

    public void setAccountType(int accountType){
        this.accountType=accountType;
    }

}
