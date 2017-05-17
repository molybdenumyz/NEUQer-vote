package com.neuqer.voter.service.impl;

import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.Token;
import com.neuqer.voter.exception.Auth.NeedLoginException;
import com.neuqer.voter.exception.Auth.TokenExpireException;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.mapper.TokenMapper;
import com.neuqer.voter.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yinzhe on 17/5/9.
 */
@Service("TokenService")
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenMapper tokenMapper;

    private final static long EXPIRE_TIME = 3600000;

    @Override
    public Token getTokenByUserId(long userId) {
        return tokenMapper.getTokenByUserId(userId);
    }

    @Override
    public Token generateToken(long userId, int client, String ip) throws BaseException {

        Token token = tokenMapper.getTokenByUserId(userId);

        long current = Utils.createTimeStamp();

        // 新建
        if (token == null) {
            token = new Token();
            token.setUserId(userId);
            token.setClient(client);
            token.setIp(ip);

            token.setToken(Utils.createUUID());

            token.setCreatedAt(current);
            token.setUpdatedAt(current);
            token.setExpireAt(current + EXPIRE_TIME);

            if (tokenMapper.createToken(token) != 1) {
                throw new UnknownException("Fail to create token");
            }
        } else {
            //更新已有的token
            token.setToken(Utils.createUUID());
            token.setUpdatedAt(current);
            token.setExpireAt(current + EXPIRE_TIME);
            token.setClient(client);
            token.setIp(ip);

            if (tokenMapper.updateToken(token) != 1) {
                throw new UnknownException("Fail to update token");
            }
        }

        return token;
    }

    @Override
    public Token verifyToken(String tokenStr) throws BaseException {
        Token token = tokenMapper.getTokenByStr(tokenStr);

        if (token == null) {
            throw new NeedLoginException();
        } else if (token.getExpireAt() < Utils.createTimeStamp()) {
            throw new TokenExpireException();
        }

        return token;
    }

    @Override
    public boolean destroyToken(long userId) throws BaseException {
        Token token = tokenMapper.getTokenByUserId(userId);
        token.setToken("");
        if (tokenMapper.updateToken(token) < 1) {
            throw new UnknownException("Fail to destroy token");
        } else {
            return true;
        }

    }
}
