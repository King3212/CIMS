package com.cat_back.security;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.cat_back.config.SMSConfig;
import com.cat_back.service.RedisServer;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class SMSUtil {
    private final SMSConfig smsConfig;
    private final Client smsClient;
    // 从阿里云控制台获取的固定参数
    private static final String SIGN_NAME = "\n" + "CIMS项目";
    static private final ArrayList<String> TemplateCodes = new ArrayList<>();

    public SMSUtil() throws Exception {
        this.smsConfig = new SMSConfig();
        this.smsClient = createClient();
        TemplateCodes.add("SMS_480185121");
        TemplateCodes.add("SMS_480185122");
        TemplateCodes.add("SMS_480235118");
    }

    private Client createClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(smsConfig.getAccessKeyId())
                .setAccessKeySecret(smsConfig.getAccessKeySecret());
        // 短信API的endpoint
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }


    public int sendCode(String code, String phoneNumber,@Param("0 for login,1 for newAcc,2 for editPasswd") int type) {
        // 手机号验证
        if (!isValidPhoneNumber(phoneNumber)) {
            return 1; // 无效的手机号格式
        }

        try {
            SendSmsRequest request = new SendSmsRequest()
                    .setPhoneNumbers(phoneNumber)
                    .setSignName(SIGN_NAME)
                    .setTemplateCode(TemplateCodes.get(type))
                    .setTemplateParam("{\"code\":\"" + code + "\"}");

            SendSmsResponse response = smsClient.sendSms(request);

            if (!"OK".equalsIgnoreCase(response.getBody().getCode())) {
                System.err.println("短信发送失败，响应信息：" + new Gson().toJson(response));
                return 2; // 短信服务返回错误
            }

            return 0; // 发送成功
        } catch (Exception e) {
            System.err.println("短信发送异常：" + e.getMessage());
            e.printStackTrace();
            return 3; // 系统异常
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // 更严格的手机号验证正则
        phoneNumber = phoneNumber.trim();
        Boolean result = phoneNumber != null && phoneNumber.matches("^1[3-9]\\d{9}$");
        System.out.println("result:"+result);
        return result;
    }

    @Autowired
    private RedisServer redisServer;

    public void storeSmsCode(String phoneNumber, String code){
        redisServer.setValue(phoneNumber,code,300);
    }

    public String getSmsCode(String phoneNumber){
        return redisServer.getValue(phoneNumber);
    }



    public String genSmsCode(String phoneNumber){
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}