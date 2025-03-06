package com.cat_back.service;

import com.cat_back.mapper.CargoMapper;
import com.cat_back.mapper.UserMapper;
import com.cat_back.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CargoService {

    @Autowired
    private CargoMapper cargoMapper;

    private int getStoreIdByUserId(@NotNull int userId) {
        UserService userService = new UserService();
        User user = userService.getUser(userId);
        return user.getStoresId();
    }


    public int newCargo (@NotNull Cargo cargo, @NotNull int user_id){
        int StoreId = getStoreIdByUserId(user_id);
        if (StoreId == 0){
            return -1; // unlegal StoreId
        }
        if (!Objects.equals(StoreId, cargo.getStoresId())){
            cargo.setStoresId(StoreId);
        }
        return cargoMapper.insertSelective(cargo);
    }

    public List<Cargo> getAllCargoByUserId(int user_id){
        int StoreId = getStoreIdByUserId(user_id);
        if (StoreId == 0){
            return new ArrayList<>(); // unlegal StoreId
        }
        CargoExample example = new CargoExample();
        CargoExample.Criteria criteria = example.createCriteria();
        criteria.andStoresIdEqualTo(StoreId);
        return cargoMapper.selectByExample(example);
    }

    public List<Cargo> getCargoByFilters(@NotNull CargoFilter cargoFilter, @NotNull int user_id){
        int StoreId = getStoreIdByUserId(user_id);
        if (StoreId == 0){
            return new ArrayList<>(); // unlegal StoreId
        }
        CargoExample example = new CargoExample();
        CargoExample.Criteria criteria = example.createCriteria();
        criteria.andStoresIdEqualTo(StoreId);
        if (Objects.nonNull(cargoFilter)){
            if (!(cargoFilter.address == null || cargoFilter.address.isEmpty())){
                criteria.andAddrLike(cargoFilter.address);
            }// find similar address

            if (!(cargoFilter.description == null || cargoFilter.description.isEmpty())){
                criteria.andDescriptionLike(cargoFilter.description);
            }// find similar description
            if (!(cargoFilter.type == null || cargoFilter.type.isEmpty())){
                criteria.andTypeEqualTo(cargoFilter.type);
            }// find same type


            if (!(cargoFilter.minPrice == null && cargoFilter.maxPrice == null)){
                if (cargoFilter.minPrice == null){

                    cargoFilter.minPrice = BigDecimal.valueOf(0);
                }else if (cargoFilter.maxPrice == null){
                    cargoFilter.maxPrice = BigDecimal.valueOf(65532);
                }
                if (cargoFilter.isSold){
                    criteria.andPriceOutGreaterThan(cargoFilter.minPrice);
                    criteria.andPriceOutLessThan(cargoFilter.maxPrice);
                }else{
                    criteria.andPriceInGreaterThanOrEqualTo(cargoFilter.minPrice);
                    criteria.andPriceInLessThanOrEqualTo(cargoFilter.maxPrice);
                }

            }// find suitable price cargo
        }
        // now select the brand and fineness
        List<Cargo> cargoList = cargoMapper.selectByExample(example);
        List<Cargo> result = new ArrayList<>();
        for  (Cargo cargo : cargoList){
            for (String fineness : cargoFilter.fineness){
                if (cargo.getFineness().equals(fineness)){
                    for (String brand : cargoFilter.brands){
                        if (cargo.getBrand().equals(brand)){
                            result.add(cargo);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<Cargo> getCargoByFiltersPaged(@NotNull CargoPageFilter cargoPageFilter, @NotNull int user_id){
        List<Cargo> cargoList = getCargoByFilters(cargoPageFilter.cargoFilter, user_id);
        List<Cargo> result = new ArrayList<>();

        if (cargoPageFilter.pageSize*(cargoPageFilter.page-1) > cargoList.size()){
            return result;
        }

        if (cargoPageFilter.orderBy == "price"){
            if (cargoPageFilter.isAsc) {
                if (cargoPageFilter.cargoFilter.isSold) {
                    cargoList.sort((c1, c2) -> c1.getPriceOut().compareTo(c2.getPriceOut()));
                } else {
                    cargoList.sort((c1, c2) -> c1.getPriceIn().compareTo(c2.getPriceIn()));
                }
            }else{
                if (cargoPageFilter.cargoFilter.isSold) {
                    cargoList.sort((c2, c1) -> c1.getPriceOut().compareTo(c2.getPriceOut()));
                } else {
                    cargoList.sort((c2, c1) -> c1.getPriceIn().compareTo(c2.getPriceIn()));
                }
            }
        }else {
            cargoList.sort((c2, c1) -> c1.getStoresId().compareTo(c2.getStoresId()));
        }


        result = cargoList.subList(cargoPageFilter.pageSize*(cargoPageFilter.page-1), Math.min(cargoList.size(), cargoPageFilter.pageSize*cargoPageFilter.page));
        return result;
    }

    public int getCargoByFiltersNum(@NotNull CargoPageFilter cargoPageFilter, @NotNull int user_id){
        List<Cargo> cargoList = getCargoByFilters(cargoPageFilter.cargoFilter, user_id);
        return cargoList.size();
    }

    public int updateCargo(@NotNull Cargo cargo, @NotNull int userId) {
        int storeId = getStoreIdByUserId(userId);
        if (storeId == 0){
            return -1; // unlegal StoreId
        }
        if (cargo.getStoresId() != storeId){
            return -1; // try to write data to another store
        }
        Cargo theCargo = cargoMapper.selectByPrimaryKey(cargo.getId());
        if (theCargo.getStoresId() != storeId){
            return -2; // try to edit data of another store
        }
        return cargoMapper.updateByPrimaryKeySelective(cargo);
    }

}


