package com.cat_back;

import com.cat_back.controllor.UserController;
import com.cat_back.model.SendSmsRequest;
import com.cat_back.model.SendSmsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsServiceTest {

    private UserController yourControllerClass = new UserController(); // 替换为包含sendSMS方法的控制器类

    @Test
    void testSendSMSSuccess() {
        // 准备测试数据
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumber("1234567890");

        // 调用被测试的方法
        SendSmsResponse response = yourControllerClass.sendSMS("15876363185");

        // 验证结果
        assertEquals(200, response.getCode());
        assertEquals("验证码已发送", response.getMessage());
    }

}