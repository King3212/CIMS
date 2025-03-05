package com.cat_back.model;

public class User {
    private int id;
    private String name;
    private String phone;       // 唯一约束
    private String openId;      // 唯一约束
    private int storesId;       // 外键关联 stores 表
    private String salt;        // 用于密码加密
    private String localHash;   // 存储加密后的密码

    // 构造方法
    public User() {}

    public User(int id, String name, String phone, String openId, int storesId, String salt, String localHash) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.openId = openId;
        this.storesId = storesId;
        this.salt = salt;
        this.localHash = localHash;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getStoresId() {
        return storesId;
    }

    public void setStoresId(int storesId) {
        this.storesId = storesId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLocalHash() {
        return localHash;
    }

    public void setLocalHash(String localHash) {
        this.localHash = localHash;
    }

    // toString 方法，方便打印对象信息
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", openId='" + openId + '\'' +
                ", storesId=" + storesId +
                ", salt='" + salt + '\'' +
                ", localHash='" + localHash + '\'' +
                '}';
    }
}
