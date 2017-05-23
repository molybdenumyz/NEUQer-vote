package com.neuqer.voter.service;

import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.dto.response.UserLoginResponse;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.User.PasswordErrorException;
import com.neuqer.voter.exception.User.UserNotExistException;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface UserService {

    User getUser(long id);

    User getUserByMobile(String mobile);

    void registerUser(User user) throws BaseException;

    User loginUser(String userMobile,String password) throws BaseException;

    boolean updateUser(User user);

    boolean forgetPassword(String mobile, String password) throws BaseException;

    boolean changeMobile(String oldMobile,String newMobile,String password) throws UserNotExistException, PasswordErrorException, UnknownException;
}
