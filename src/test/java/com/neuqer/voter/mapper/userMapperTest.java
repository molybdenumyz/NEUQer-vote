package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.User;
import com.neuqer.voter.exception.UnknownException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yinzhe on 17/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class userMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void userInsert() throws UnknownException {
        User user  = new User();

        user.setName("test");
        user.setMobile("13257300865");
        user.setPassword("admin");
        user.setStatus(2);



        try{
            userMapper.createUser(user);
        }catch (Exception e){
            throw new UnknownException("NEED UNIQUE");
        }
    }
}
