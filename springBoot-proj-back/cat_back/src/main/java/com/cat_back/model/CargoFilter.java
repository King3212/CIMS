package com.cat_back.model;

import org.apache.ibatis.jdbc.Null;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CargoFilter {
    public String type;
    public List<String> brands;
    public BigDecimal minPrice;
    public BigDecimal maxPrice;
    public List<String> fineness;
    public String address;
    public String description;
    public Boolean  isSold;
    public CargoFilter(){
        type = address =  description = null;
        brands = null;
        minPrice = null;
        maxPrice = null;
        fineness = null;
    }
}
