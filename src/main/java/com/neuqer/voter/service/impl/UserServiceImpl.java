package com.neuqer.voter.service.impl;

import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.Token;
import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.dto.response.UserLoginResponse;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.User.MobileExistedException;
import com.neuqer.voter.exception.User.PasswordErrorException;
import com.neuqer.voter.exception.User.UserNotExistException;
import com.neuqer.voter.mapper.UserMapper;
import com.neuqer.voter.mapper.VoteMapper;
import com.neuqer.voter.service.TokenService;
import com.neuqer.voter.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yinzhe on 17/5/9.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired VoteMapper voteMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public User getUser(long id) {
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }

    @Override
    public void registerUser(User user) throws BaseException {
        User newUser = userMapper.getUserByMobile(user.getMobile());

        if (newUser != null) {
            throw new MobileExistedException();
        } else {
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

            long currentTime = Utils.createTimeStamp();
            user.setCreatedAt(currentTime);
            user.setUpdatedAt(currentTime);
            int row = userMapper.createUser(user);

            if (row != 1) {
                throw new UnknownException("Fail to create user");
            }
        }
    }

    @Override
    public User registerRorbotUser(User user) {
        user.setMobile(Utils.createRobotMobile());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        long currentTime = Utils.createTimeStamp();
        user.setCreatedAt(currentTime);
        user.setUpdatedAt(currentTime);
        int row = userMapper.createUser(user);

        if (row != 1) {
            throw new UnknownException("Fail to create user");
        }

        return user;
    }

    @Override
    public User loginUser(String mobile, String password) throws BaseException {
        User user = userMapper.getUserByMobile(mobile);

        if (user == null) {
            throw new UserNotExistException();
        } else if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new PasswordErrorException();
        }
        return user;
    }

    @Override
    public User loginTeacher(String name, String password) {
        User user = userMapper.getUserByName(name);
        if (user == null) {
            throw new UserNotExistException();
        } else if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new PasswordErrorException();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user) == 1;
    }

    @Override
    public boolean forgetPassword(String mobile, String password) throws BaseException {

        User user = userMapper.getUserByMobile(mobile);

        if (user == null) {
            throw new UserNotExistException();
        } else {
            return userMapper.updateUserPassword(mobile, BCrypt.hashpw(password, BCrypt.gensalt())) == 1;
        }
    }

    @Override
    public boolean changeMobile(String oldMobile, String newMobile, String password) throws UserNotExistException, PasswordErrorException, UnknownException, MobileExistedException {
        User user = userMapper.getUserByMobile(oldMobile);

        if (user == null) {
            throw new UserNotExistException();
        } else if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new PasswordErrorException();
        }
        User userNew = userMapper.getUserByMobile(newMobile);
        if (userNew != null)
            throw new MobileExistedException();

        user.setMobile(newMobile);

        int row = userMapper.updateUser(user);

        if (row != 1)
            throw new UnknownException("update user mobile Error");

        return true;

    }
}
