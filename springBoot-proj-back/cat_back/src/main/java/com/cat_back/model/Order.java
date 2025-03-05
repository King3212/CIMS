package com.cat_back.model;

import java.util.Date;

public class Order {
    private int id;
    private int usersId;   // 外键关联 users 表
    private int goodsId;   // 外键关联 cargos 表
    private Date dealTime; // 交易时间
    private int storesId;  // 外键关联 stores 表

    // 构造方法
    public Order() {}

    public Order(int id, int usersId, int goodsId, Date dealTime, int storesId) {
        this.id = id;
        this.usersId = usersId;
        this.goodsId = goodsId;
        this.dealTime = dealTime;
        this.storesId = storesId;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public int getStoresId() {
        return storesId;
    }

    public void setStoresId(int storesId) {
        this.storesId = storesId;
    }

    // toString 方法，方便打印对象信息
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", usersId=" + usersId +
                ", goodsId=" + goodsId +
                ", dealTime=" + dealTime +
                ", storesId=" + storesId +
                '}';
    }
}

