/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cat_back;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

/**
 *
 * @author king3212
 */
public class GoodSpecification {
    public static Specification<Good> filterGoods(String type, List<String> brands, Double min_price, Double max_price, String desc, String addr, boolean sold){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (type != null && !type.isEmpty()){
                predicates.add(root.get("type").in(brands));
            }
            
            if (brands != null && brands.isEmpty()){
                predicates.add(root.get("brand").in(brands));
            }

            String price = "price_out";
            if (sold){
                price = "price_in";
            }

            if (min_price != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(price), min_price));
            }

            if (max_price != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(price), max_price));
            }

            if (desc != null && !desc.isEmpty()){
                predicates.add(criteriaBuilder.like((root.get("desc")), "%"+type+"%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
