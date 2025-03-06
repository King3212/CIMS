package com.cat_back.model;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer usersId;

    private Integer cargosId;

    private Date dealTime;

    private Integer storesId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getCargosId() {
        return cargosId;
    }

    public void setCargosId(Integer cargosId) {
        this.cargosId = cargosId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }
}