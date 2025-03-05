/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cat_back.mapper;

import org.apache.ibatis.annotations.Param;

import com.cat_back.model.Store;

/**
 *
 * @author king3212
 */
public interface  StoreMapper {
    Store findById(@Param("id") Long id);
    void insertOne(@Param("store") Store store);
    void editManager(@Param("store") Store store);
    void editName(@Param("store") Store store);
    void DeleteStore(@Param("store") Store store);
}
