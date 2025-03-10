package com.cat_back.controllor;

import com.cat_back.model.*;
import com.cat_back.security.JwtTokenProvider;
import com.cat_back.security.SHA3Hash;
import com.cat_back.security.SMSUtil;
import com.cat_back.service.RedisServer;
import com.cat_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

@RestController
@RequestMapping("/User")
public class UserController {

    private SMSUtil smsUtil;

    // JUST SEND SMS


}
