package com.cat_back.model;

public class CargoFilterParams {
    private String type;
    private String brand;
    private Double minPrice;
    private Double maxPrice;
    private Integer fineness;
    private Integer storesId;
    private String description;

    // Getters and Setters
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

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getFineness() {
        return fineness;
    }

    public void setFineness(Integer fineness) {
        this.fineness = fineness;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}