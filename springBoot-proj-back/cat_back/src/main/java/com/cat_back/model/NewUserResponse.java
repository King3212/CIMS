package com.cat_back.model;

import io.jsonwebtoken.Jwt;

public class NewUserResponse {
    private int status;
    private String message;
    private Jwt jwt;

    public void setStatus(int status){
        this.status = status;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setJwt(Jwt jwt){
        this.jwt = jwt;
    }
}
