package com.cat_back.controllor;

import com.cat_back.model.*;
import com.cat_back.security.SHA3Hash;
import com.cat_back.security.SMSUtil;
import com.cat_back.service.RedisServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

@RestController
@RequestMapping("/User")
public class UserController {

    private SMSUtil smsUtil;

    @PostMapping("/CreateUserSendSMS")
    public SendSmsResponse sendSMS(@RequestBody SendSmsRequest request){
        String code = genSmsCode(request.getPhoneNumber());
        storeSmsCode(request.getPhoneNumber(),  code);
        int isSent = smsUtil.sendCode(code, request.getPhoneNumber(), 0);

        SendSmsResponse sendSmsResponse = new SendSmsResponse();
        if (isSent == 0){
            sendSmsResponse.setCode(200);
            sendSmsResponse.setMessage("验证码已发送");
        } else if (isSent == 1) {
            sendSmsResponse.setCode(500);
            sendSmsResponse.setMessage("无效的手机号");
        } else if (isSent == 2) {
            sendSmsResponse.setCode(501);
            sendSmsResponse.setMessage("短信发送失败");
        } else {
            sendSmsResponse.setCode(501);
            sendSmsResponse.setMessage("系统异常");
        }
        return sendSmsResponse;
    }
    private String genSmsCode(String phoneNumber){
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }

    private void storeSmsCode(String phoneNumber, String code){
        RedisServer  redisServer = new RedisServer();
        redisServer.delValue(phoneNumber);
        redisServer.setValue(phoneNumber,code,300);
    }

    private String getSmsCode(String phoneNumber){
        RedisServer  redisServer = new RedisServer();
        return redisServer.getValue(phoneNumber);
    }

    @PostMapping("/CreateUserCheckSMS")
    public NewUserResponse  createUserCheckSMS(@RequestBody NewUserRequest request){
        NewUserResponse newUserResponse = new NewUserResponse();
        if (!request.getSmsCode().equals(getSmsCode(request.getPhone()))){
            newUserResponse.setStatus(500);
            newUserResponse.setMessage("验证码错误");
            return newUserResponse;
        }

        User user = new User();
        String randomCode = new BigInteger(130, new SecureRandom()).toString(32) + "CIMS";
        user.setRandomCode(randomCode);
        SHA3Hash hash = new SHA3Hash();
        String localHash = hash.hash(request.getPassword()+randomCode);
        user.setLocalHash(localHash);

        user.setName(request.getName());
        user.setOpenId("");
        user.setPhone(request.getPhone());








        return  newUserResponse;
    }



}
