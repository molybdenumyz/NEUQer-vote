package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.Vote;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface UserMapper {

    User getUser(@Param("id") long id);

    User getUserWithTrashed(@Param("id") long id);

    User getUserByMobile(@Param("mobile") String mobile);
    User getUserByName(@Param("name") String name);
    Integer createUser(User user);

    Integer deleteUser(@Param("id") long id);

    Integer forceDeleteUser(@Param("id") long id);

    Integer updateUser(@Param("user") User user);

    Integer updateUserPassword(@Param("mobile") String mobile, @Param("password") String password);
}
