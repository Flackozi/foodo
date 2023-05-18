package com.example.foodo.model;

public abstract class GenericUserModel {
    private String username;

    private int profileType; //0->user, 1->chef


    protected GenericUserModel(String username, int profileType){
        setUsername(username);
        setProfileType(profileType);
    }
    protected GenericUserModel(String username){
        setUsername(username);
    }
    public String getUsername() {
        return username;
    }
    public int getProfileType() {
        return profileType;
    }
    private void setProfileType(int profileType) {
        this.profileType=profileType;
    }
    private void setUsername(String username) {
        this.username=username;
    }
}
