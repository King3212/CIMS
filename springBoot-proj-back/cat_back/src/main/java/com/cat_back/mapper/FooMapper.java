/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cat_back.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author king3212
 */

@Mapper
public interface FooMapper {
    LocalDateTime now();
}
