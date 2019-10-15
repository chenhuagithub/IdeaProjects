package com.atguigu.utils;


import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VerificationCode {

    public  YunpianClient clnt = new YunpianClient("78ccbe77a41da6a50c3da6a67d46b489").init();

    public  Result<SmsSingleSend> SingleSend (String phone, String code){
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, phone);
        param.put(YunpianClient.TEXT, "【陈华征程】您的验证码是"+code+"。如非本人操作，请忽略本短信");
        return clnt.sms().single_send(param);
    }



}
