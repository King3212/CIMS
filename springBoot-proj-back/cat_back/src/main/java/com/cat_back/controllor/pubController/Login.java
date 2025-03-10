package com.cat_back.controllor.pubController;

import com.cat_back.model.*;
import com.cat_back.security.JwtTokenProvider;
import com.cat_back.security.SHA3Hash;
import com.cat_back.security.SMSUtil;
import com.cat_back.service.RedisServer;
import com.cat_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cat_back.security.SMSUtil;
import java.math.BigInteger;
import java.security.SecureRandom;

@RestController
@RequestMapping("/public")
public class Login {

    private SMSUtil smsUtil;

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private RedisServer redisServer;

    @PostMapping("/SendSms/CreateUser")
    public SendSmsResponse sendSMS(@RequestBody SendSmsRequest request) {

    }

    // SEND SMS FOR LOGIN
    @PostMapping("/SendSms/Login")
    public SendSmsResponse sendSmsForLogin(@RequestBody SendSmsRequest request){
        return sendSMS(request,1);
    }

    // CHECK THE SMS , CREATE A USER AND RETURN JWT
    @PostMapping("/CheckSms/CreateUser")
    public NewUserResponse createUserCheckSMS(@RequestBody NewUserRequest request){
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

        UserService userService = new UserService();
        userService.newUser(user);

        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String jwt = jwtTokenProvider.createToken(request.getName());

        newUserResponse.setJwt(jwt);
        return  newUserResponse;
    }



    public com.cat_back.model.SendSmsResponse sendSMS(com.cat_back.model.SendSmsRequest request, int type){
        String code = smsUtil.genSmsCode(request.getPhoneNumber());
        smsUtil.storeSmsCode(request.getPhoneNumber(),  code);

        try {
            smsUtil = new SMSUtil();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int isSent = smsUtil.sendCode(code, request.getPhoneNumber(), type);

        com.cat_back.model.SendSmsResponse sendSmsResponse = new com.cat_back.model.SendSmsResponse();
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



}
