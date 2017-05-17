package com.neuqer.voter.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuqer.voter.common.Response;
import com.neuqer.voter.common.Validator;
import com.neuqer.voter.domain.Token;
import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.VerifyCode;
import com.neuqer.voter.dto.request.UserLoginRequest;
import com.neuqer.voter.dto.request.UserRegisterRequest;
import com.neuqer.voter.dto.request.VerifyCodeRequest;
import com.neuqer.voter.dto.response.UserLoginResponse;
import com.neuqer.voter.dto.response.VerifyResponse;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.User.IlegaleMobileException;
import com.neuqer.voter.exception.User.MobileExistedException;
import com.neuqer.voter.exception.User.PasswordErrorException;
import com.neuqer.voter.exception.User.UserExistedException;
import com.neuqer.voter.exception.VerifyCode.IllegalTypeException;
import com.neuqer.voter.exception.VerifyCode.IllegalVerfyCodeException;
import com.neuqer.voter.service.TokenService;
import com.neuqer.voter.service.UserService;
import com.neuqer.voter.service.VerifyCodeService;
import org.apache.ibatis.annotations.ResultMap;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by yinzhe on 17/5/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private VerifyCodeService verifyCodeService;

    /**
     * 获取手机验证码
     * @param  request VerifyCodeRequest dto 对象
     * @return 0
     *
     */

    @RequestMapping(path = "/verify", method = RequestMethod.POST)
    public Response getVerifyCode(
            @RequestBody @Valid VerifyCodeRequest request) throws BaseException {
        int type = request.getType();

        String mobile = request.getMobile();

        if (!Validator.validateMobile(mobile))
            throw new IlegaleMobileException();


        if (!Validator.validatorType(type))
            throw new IllegalTypeException();

        User user = userService.getUserByMobile(mobile);
        if (user != null)
            throw new MobileExistedException();
        VerifyResponse response = new VerifyResponse("1234");
        if (verifyCodeService.sendVerifyCode(mobile, type))
            return new Response(0,response);
        throw new UnknownException();
    }
    /**
     * 用户登录
     *
     * @param request UserLoginRequest dto对象
     * @return User, Token
     * @throws BaseException 基础异常
     */

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody @Valid UserLoginRequest request) throws BaseException {

        User user = userService.loginUser(request.getMobile(), request.getPassword());
        Token token = tokenService.generateToken(user.getId(), 1, "unknown");
        UserLoginResponse response = new UserLoginResponse(user, token.getToken());

        return new Response(0, response);
    }


    /**
     * 用户登出
     *
     * @param request
     * @return
     * @throws BaseException
     */

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public Response logout(HttpServletRequest request) throws BaseException {
        User user = (User) request.getAttribute("user");

        tokenService.destroyToken(user.getId());

        return new Response(0, null);
    }


    /**
     * 用户注册
     *
     * @param request UserRegisterRequest dto对象
     * @throws BaseException 基础异常
     */

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody @Valid UserRegisterRequest request) throws BaseException {
        String mobile = request.getMobile();
        String code = request.getCode();
        /**
         * 验证手机号合法性
         */
        if(!Validator.validateMobile(mobile)) {
            throw new IlegaleMobileException();
        }

        /**
         * 验证验证码
         */
        if (!verifyCodeService.checkVerifyCode(mobile,1,code))
            throw new IllegalVerfyCodeException();
        String password = request.getPassword();
        User user = new User();
        user.setName(null);
        user.setMobile(request.getMobile());
        user.setPassword(request.getPassword());

        userService.registerUser(user);

        return new Response(0, null);
    }

    /**
     * 获取当前登录的用户信息
     *
     * @param request HttpServletRequest 基本http请求
     * @return User 当前登录的用户模型
     * @throws BaseException 基础异常
     */

    @RequestMapping(path = "/me", method = RequestMethod.GET)
    public Response getCurrentUserInfo(HttpServletRequest request) throws BaseException {

        User user = (User) request.getAttribute("user");

        user.setPassword(null);

        return new Response(0, user);
    }

    /**
     * 更改用户密码
     *
     * @param request     HttpServletRequest 基本http请求
     * @param jsonRequest jsonRequest json请求
     * @throws BaseException 基本异常
     */

    @RequestMapping(path = "/password", method = RequestMethod.PUT)
    public Response resetPassword(HttpServletRequest request, @RequestBody JSONObject jsonRequest) throws BaseException {
        String oldPassword = jsonRequest.getString("oldPassword");
        String newPassword = jsonRequest.getString("newPassword");

        User user = (User) request.getAttribute("user");

        if (!BCrypt.checkpw(oldPassword, user.getPassword())) {
            throw new PasswordErrorException();
        }

        user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));

        if (!userService.updateUser(user)) {
            throw new UnknownException("fail to update user password");
        }

        return new Response(0, null);
    }

    /**
     * 更改名称
     *
     * @param request     HttpServletRequest 基本http请求
     * @param jsonRequest json请求内容
     * @throws BaseException 基础异常
     */

    @RequestMapping(path = "/nickname", method = RequestMethod.PUT)
    public Response resetNickName(HttpServletRequest request, @RequestBody JSONObject jsonRequest) throws BaseException {
        String newName = jsonRequest.getString("newName");

        User user = (User) request.getAttribute("user");

        user.setName(newName);

        if (!userService.updateUser(user)) {
            throw new UnknownException("fail to update user's nickname");
        }

        return new Response(0, null);
    }

    /**
     * 忘记密码
     *
     * @param jsonRequest json请求内容
     * @throws BaseException 基础异常
     */

    @RequestMapping(path = "/forget", method = RequestMethod.PUT)
    public Response forgetPassword(@RequestBody JSONObject jsonRequest) throws BaseException {
        String mobile = jsonRequest.getString("mobile");
        String newPassword = jsonRequest.getString("newPassword");

        if (!userService.forgetPassword(mobile, newPassword)) {
            throw new UnknownException("fail to update user's password");
        }

        return new Response(0, null);
    }
}
