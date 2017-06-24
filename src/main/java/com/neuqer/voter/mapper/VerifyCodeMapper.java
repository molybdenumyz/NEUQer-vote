package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.VerifyCode;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface VerifyCodeMapper {
    boolean addVerifyCode(VerifyCode verifyCode);

    VerifyCode getVerifyCode(VerifyCode verifyCode);

    boolean updateVerifyCode(VerifyCode verifyCode);

    Integer deleteVerifyCode(VerifyCode verifyCode);
}
