package com.neuqer.voter.common;


import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinzhe on 17/6/4.
 */
public class SmsSender {

    public String Sender(String mobile,String code) throws Exception{
        String url = "http://zapi.253.com/msg/HttpBatchSendSM?account={account}&pswd={pswd}&mobile={mobile}&msg={msg}";
        String message = "【NEUQer】欢迎使用投票服务，您的验证码："+code+"，有效期五分钟";
        Map<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("account", "N4129357");
        urlVariables.put("pswd","yC7o2HZ6RF8d7a");
        urlVariables.put("mobile",mobile);
        urlVariables.put("msg", message);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url,String.class, urlVariables);

    }
}