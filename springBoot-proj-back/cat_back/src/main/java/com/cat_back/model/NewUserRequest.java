package com.cat_back.model;

public class NewUserRequest {
    private Integer id;

    private String name;

    private String phone;

    private Integer storesId;

    private String password;

    private String smsCode;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public Integer getStoresId()
    {
        return storesId;
    }
    public String getPassword() {
        return password;
    }
    public String getSmsCode() {
        return smsCode;
    }
}
