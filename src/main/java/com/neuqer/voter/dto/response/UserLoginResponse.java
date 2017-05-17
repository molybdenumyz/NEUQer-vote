package com.neuqer.voter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by lumin on 17/3/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginResponse {

    public UserLoginResponse(com.neuqer.voter.domain.User user, String token) {
        this.user = new User();
        this.user.setUserId(user.getId());
        this.user.setMobile(user.getMobile());
        this.token = token;
    }

    private User user;

    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    //定义响应返回的数据模型，去除密码字段

    public class User {
        private long userId;
        private String mobile;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

}
