/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cat_back;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author king3212
 */

@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (nullable = false, unique = true)
    private String type;

    @Column (nullable = false, unique = false)
    private String brand;

    @Column 
    private Double price_in;

    @Column 
    private String desc;
    
    @Column 
    private String addr;

    @Column 
    private String pic_addr;

    @Column
    private String fineness;

    @Column (nullable = false)
    private long store_id;
}
