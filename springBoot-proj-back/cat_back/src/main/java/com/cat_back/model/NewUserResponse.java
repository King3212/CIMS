package com.cat_back.model;


public class NewUserResponse {
    private int status;
    private String message;
    private String jwt;

    public void setStatus(int status){
        this.status = status;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setJwt(String jwt){
        this.jwt = jwt;
    }
}
