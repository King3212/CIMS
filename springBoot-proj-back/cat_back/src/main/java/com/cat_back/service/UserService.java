package com.cat_back.service;


import com.cat_back.mapper.UserMapper;
import com.cat_back.model.User;
import com.cat_back.model.UserExample;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int id){
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);
        return userMapper.selectByExample(example).getFirst();
    }

    public void newUser(User user){

        userMapper.insertSelective(user);
    }

    public void newUser(User user, int userId){
        User theInviter =  userMapper.selectByPrimaryKey(userId);
        user.setStoresId(theInviter.getStoresId());
        userMapper.insert(user);
    }

    public void updateUser(User user, int userId){
        User theInviter =  userMapper.selectByPrimaryKey(userId);
        user.setStoresId(theInviter.getStoresId());
    }

    public boolean checkPassword(int userId, String hashedPassword, String randomCode){
        User user = userMapper.selectByPrimaryKey(userId);
        String localHash = user.getLocalHash();
        String input = localHash + randomCode;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString() == hashedPassword;

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return false;
        }

    }


}

