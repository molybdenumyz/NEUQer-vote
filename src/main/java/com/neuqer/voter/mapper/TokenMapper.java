package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.Token;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface TokenMapper {

    Token getTokenByUserId(@Param("userId") long userId);

    Token getTokenByStr(@Param("tokenStr") String token);

    Integer createToken(Token token);

    Integer updateToken(Token token);

    Integer deleteToken(@Param("id") long tokenId);
}
