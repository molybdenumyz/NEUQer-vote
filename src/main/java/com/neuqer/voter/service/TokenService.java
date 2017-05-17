package com.neuqer.voter.service;

import com.neuqer.voter.domain.Token;
import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface TokenService {

    Token getTokenByUserId(long userId);

    Token generateToken(long userId, int client, String ip) throws BaseException;

    Token verifyToken(String tokenStr) throws BaseException;

    boolean destroyToken(long userId) throws BaseException;
}
