package com.neuqer.voter.service.impl;

import com.neuqer.voter.domain.*;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.mapper.RelationMapper;
import com.neuqer.voter.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yinzhe on 17/6/23.
 */
@Service("RelationService")
public class RelationServiceImpl implements RelationService{
    @Autowired
    private RelationMapper relationMapper;
    @Override
    public boolean createVoteProjectRelation(VoteProjectRelation voteProjectRelation) {
        int row = relationMapper.createVoteProjectRelation(voteProjectRelation);
        if (row<1){
            throw new UnknownException("创建投票项目关系失败");
        }else
            return true;
    }

    @Override
    public boolean createVoteMaringRelation(VoteMaringRelation voteMaringRelation) {
        int row = relationMapper.createVoteMaringRelation(voteMaringRelation);
        if (row<1){
            throw new UnknownException("创建投票小项关系失败");
        }else
            return true;
    }

    @Override
    public boolean createVoteTeacherRelation(VoteTeacherRelation voteTeacherRelation) {
        int row = relationMapper.createVoteTeacherRelation(voteTeacherRelation);
        if (row<1){
            throw new UnknownException("创建投票教师关系失败");
        }else
            return true;
    }

    @Override
    public boolean createActivityMaringRelation(ActivityMaringRelation activityMaringRelation) {
        int row = relationMapper.createActivityMaringRelation(activityMaringRelation);
        if (row<1){
            throw new UnknownException("创建活动小项关系失败");
        }else
            return true;
    }

    @Override
    public boolean createActivityProjectRelation(ActivityProject activityProject) {

        int row = relationMapper.createActivityProjectRelation(activityProject);
        if (row<1){
            throw new UnknownException("关联活动失败");
        }else
            return true;
    }

    @Override
    public Long getProjectIdByVoteId(long voteId) {
        return  relationMapper.findProjectIdByVoteId(voteId);
    }
}
