package com.neuqer.voter.config;

import com.neuqer.voter.interceptor.EnableCORSInterceptor;
import com.neuqer.voter.interceptor.TokenInterceptor;
import com.neuqer.voter.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yinzhe on 17/5/9.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    private TokenInterceptor tokenInterceptor;
    private EnableCORSInterceptor enableCORSInterceptor;

    @Autowired
    public WebConfig(TokenInterceptor tokenInterceptor, EnableCORSInterceptor enableCORSInterceptor) {
        this.enableCORSInterceptor = enableCORSInterceptor;
        this.tokenInterceptor = tokenInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(enableCORSInterceptor);
        registry.addInterceptor(tokenInterceptor);
        super.addInterceptors(registry);
    }
}
