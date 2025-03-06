package com.cat_back.service;

import com.cat_back.mapper.StoreMapper;
import com.cat_back.model.Store;
import com.cat_back.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    StoreMapper storeMapper;

    private int getStoreIdByUserId(@NotNull int userId) {
        UserService userService = new UserService();
        User user = userService.getUser(userId);
        return user.getStoresId();
    }

    public int newStore (Store store, int userId){
        int storeId =  getStoreIdByUserId(userId);
        if (storeId == 0){
            store.setManagerId(userId);
            storeId = storeMapper.insert(store);
        }
        return storeId;
    }
}
