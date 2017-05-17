package com.neuqer.voter.service;

import com.neuqer.voter.exception.BaseException;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface CreatorService {
    boolean isCreator(long voteId, long creatorId) throws BaseException;
}
