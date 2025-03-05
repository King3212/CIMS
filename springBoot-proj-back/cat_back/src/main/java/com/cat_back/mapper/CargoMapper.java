package com.cat_back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cat_back.model.Cargo;
import com.cat_back.model.CargoFilterParams;

public interface CargoMapper {
    // 按条件筛选货物并分页
    
    List<Cargo> filterCargosUnselt(@Param("params") CargoFilterParams params);

    List<Cargo> filterCargosSelt(@Param("params") CargoFilterParams params);

    Cargo findById(@Param("id") Long id);
}