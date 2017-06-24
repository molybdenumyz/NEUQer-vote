package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/5/9.
 */
public class VerifyCode  {
   private String mobile;
   private Integer type;
   private String code;
   private long expireAt;
   private long updateAt;
   private Integer num;

    public VerifyCode(){

    }
    public VerifyCode(String mobile, Integer type, String code, long expireAt) {
        this.mobile = mobile;
        this.type = type;
        this.code = code;
        this.expireAt = expireAt;
    }

    public VerifyCode(String mobile, int type) {
        this.mobile = mobile;
        this.type = type;

    }

    public VerifyCode(String mobile,int type,String code){
        this.mobile = mobile;
        this.type = type;
        this.code = code;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(long expireAt) {
        this.expireAt = expireAt;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "VerifyCode{" +
                "mobile='" + mobile + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", expireAt=" + expireAt +
                ", updateAt=" + updateAt +
                ", num=" + num +
                '}';
    }
}
