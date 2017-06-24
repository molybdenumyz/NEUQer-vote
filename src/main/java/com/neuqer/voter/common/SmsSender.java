package com.neuqer.voter.common;


import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinzhe on 17/6/4.
 */
public class SmsSender {

    public String Sender(String mobile,String code) throws Exception{
        //String url = "http://zapi.253.com/msg/HttpBatchSendSM?account={account}&pswd={pswd}&mobile={mobile}&msg={msg}";
        String url = "http://sms.253.com/msg/send?un={un}&pw={pw}&phone={phone}&msg={msg}&rd=1";
//        String message = "【NEUQer】欢迎使用投票服务，您的验证码："+code+"，有效期五分钟";
        String message = "欢迎使用投票服务，您的验证码："+code+"，有效期五分钟";
        Map<String, Object> urlVariables = new HashMap<String, Object>();
//        urlVariables.put("account", "xxx" +
//                "");
//        urlVariables.put("pswd","xxx");
//        urlVariables.put("mobile",mobile);
        urlVariables.put("msg", message);
        urlVariables.put("un","N6739942");
        urlVariables.put("phone",mobile);
        urlVariables.put("pw","Tch123456");
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url,String.class, urlVariables);


    }
}
