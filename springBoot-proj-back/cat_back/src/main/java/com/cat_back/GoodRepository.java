/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.cat_back;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author king3212
 */
public interface GoodRepository extends  CrudRepository<Good, Long> {
    List<Good> findGoods (String type, List<String> brand);
    
}
