package com.neuqer.voter.service.impl;

import com.github.pagehelper.PageHelper;
import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.Derecord;
import com.neuqer.voter.domain.Maring;
import com.neuqer.voter.domain.VoteNeed;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.Vote.VoteNotExistException;
import com.neuqer.voter.mapper.TeacherMapper;
import com.neuqer.voter.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public List<VoteNeed> allVoteToTeacher(Long userId,int page,int rows) {
        PageHelper.startPage(page, rows);

        List<VoteNeed> votes = teacherMapper.getVoteByUserId(userId);
        long now = Utils.createTimeStamp();

        if (votes.isEmpty())
            throw new VoteNotExistException();

        for (VoteNeed vote:votes
                ) {
            if (now < vote.getStartTime())
                vote.setFlag(0);
            else if (now > vote.getStartTime() && vote.getEndTime() > now)
                vote.setFlag(1);
            else
                vote.setFlag(2);
        }

        return votes;
    }

    @Override
    public List<Maring> MaringToVote(long voteId) {
        List<Maring> list= teacherMapper.getMaringByVoteId(voteId);
        return list;
    }

    @Override
    public boolean SubmitToDerecord(Derecord derecord) {
      int row =  teacherMapper.insertDerecord(derecord);
        if (row < 1){
            throw new UnknownException("记录计入失败");
        }
        else return true;
    }
}
