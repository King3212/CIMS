package com.cat_back;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
@MapperScan(basePackages = "com.cat_back.mapper", annotationClass = Mapper.class)
public class CatBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatBackApplication.class, args);
    }


}
