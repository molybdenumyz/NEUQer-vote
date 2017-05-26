package com.neuqer.voter.interceptor;

import com.neuqer.voter.domain.Token;
import com.neuqer.voter.domain.User;
import com.neuqer.voter.exception.Auth.NeedLoginException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.service.TokenService;
import com.neuqer.voter.service.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yinzhe on 17/5/9.
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {


    private TokenService tokenService;
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Autowired
    public TokenInterceptor(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }


    // 不检查token的请求路由
    private final static ArrayList<String> URLS_WITHOUT_TOKEN = new ArrayList<String>() {{
        add("/user/login");
        add("/user/register");
        add("/user/forget");
        add("/error");
        add("/record");
        add("/user/verify");
        add("/admin/login");
        add("/vote/info");
        add("/vote/all");
        add("/user/forget");
    }};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String nowUrl = request.getRequestURI();
        String token = request.getHeader("token");
        logger.debug("get request from: " + nowUrl + "with METHOD: " + request.getMethod());

        if (request.getMethod().equals("OPTIONS"))
            return true;

        for (String url : URLS_WITHOUT_TOKEN) {
            if (url.equals(nowUrl)) {
                return true;
            }
        }

        if (token == null || token.equals("")) {
            throw new NeedLoginException();
        }

        if (tokenService == null) {
            throw new UnknownException();
        }
        Token tokenObj = tokenService.verifyToken(token);
        User user = userService.getUser(tokenObj.getUserId());
        request.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
