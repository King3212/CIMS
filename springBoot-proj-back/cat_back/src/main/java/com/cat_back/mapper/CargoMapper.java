package com.cat_back.mapper;

import com.cat_back.model.Cargo;
import com.cat_back.model.CargoExample;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CargoMapper {
    int countByExample(CargoExample example);

    int deleteByExample(CargoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    List<Cargo> selectByExample(CargoExample example);

    Cargo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cargo record, @Param("example") CargoExample example);

    int updateByExample(@Param("record") Cargo record, @Param("example") CargoExample example);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);
}