package com.cat_back.model;

public class Cargo {
    private int id;
    private String type;
    private String brand;
    private double priceIn;
    private double priceOut;
    private String description;
    private String address;
    private String picAddress;
    private String fineness;
    private int storesId;  // 外键关联 stores 表

    // 构造方法
    public Cargo() {}

    public Cargo(int id, String type, String brand, double priceIn, double priceOut, 
                 String description, String address, String picAddress, String fineness, int storesId) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.description = description;
        this.address = address;
        this.picAddress = picAddress;
        this.fineness = fineness;
        this.storesId = storesId;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(double priceOut) {
        this.priceOut = priceOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    public String getFineness() {
        return fineness;
    }

    public void setFineness(String fineness) {
        this.fineness = fineness;
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
        return "Cargo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", priceIn=" + priceIn +
                ", priceOut=" + priceOut +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", picAddress='" + picAddress + '\'' +
                ", fineness='" + fineness + '\'' +
                ", storesId=" + storesId +
                '}';
    }
}
