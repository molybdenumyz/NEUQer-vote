package com.neuqer.voter.service.impl;

import com.github.pagehelper.PageHelper;
import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteNeed;
import com.neuqer.voter.domain.VoteRecord;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.Vote.FormErrorException;
import com.neuqer.voter.exception.Vote.HaveVotedException;
import com.neuqer.voter.exception.Vote.TimeErrorException;
import com.neuqer.voter.exception.Vote.VoteNotExistException;
import com.neuqer.voter.mapper.OptionMapper;
import com.neuqer.voter.mapper.VoteMapper;
import com.neuqer.voter.mapper.VoteRecordMapper;
import com.neuqer.voter.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yinzhe on 17/5/13.
 */
@Service("voteService")
public class VoteServiceImpl implements VoteService{
    @Autowired
    VoteMapper voteMapper;

    @Autowired
    OptionMapper optionMapper;

    @Autowired
    VoteRecordMapper voteRecordMapper;
    @Override
    public Vote getVoteInfo(long id) throws BaseException {
        Vote vote = voteMapper.getVote(id);
        if (vote == null)
            throw new VoteNotExistException();
        return vote;
    }

    @Override
    public List<VoteNeed> getAllVote(int page, int rows) throws BaseException {

        PageHelper.startPage(page, rows);

        List<VoteNeed> votes = voteMapper.getAllVote();

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
    public boolean joinVote(long id, String password) throws BaseException {
        return false;
    }


    @Override
    @Transactional
    public boolean submitVote(long voteId,long userId,List<VoteRecord> voteRecords) throws BaseException {
        //检查投票时间
        //检查投票可见性
        //检查是否已经删除
        Vote vote = voteMapper.getVote(voteId);
        if (vote == null)
            throw new VoteNotExistException();

        int type = vote.getType();
        long now = Utils.createTimeStamp();
//        if (!(now > vote.getStartTime() && now <vote.getEndTime()))
//           throw new TimeErrorException("投票未开始或者已结束");

        //检查是否已经提交过
       if ( voteRecordMapper.findRecord(voteId,userId).size()!= 0 )
           throw new HaveVotedException();
        int size = 0;
        try {
            size = voteRecords.size();
        }catch (Exception e)
        {
            throw new FormErrorException("请正确提交投票，voteRecords丢失");
        }


        if (type == 1){
            if (size != 1)
                throw new FormErrorException("单选题只能选一题");

            for (VoteRecord voteRecord: voteRecords
                    ) {
                voteRecord.setUserId(userId);
                voteRecord.setVoteId(voteId);
                voteRecord.setCreateAt(now);
                voteRecord.setUpdateAt(now);


                int row = voteRecordMapper.addRecord(voteRecord);
                if (row == 1)
                row = optionMapper.updateOptionChooseNum(voteRecord.getOptionId());
                else
                    throw new UnknownException("增加投票记录失败");
                if (row != 1)
                    throw new UnknownException("更新选项数据失败");
            }
        }
        else if (type == 2){

            for (VoteRecord voteRecord: voteRecords
                    ) {

                voteRecord.setVoteId(voteId);
                voteRecord.setCreateAt(now);
                voteRecord.setUpdateAt(now);
                voteRecord.setUserId(userId);

                int row = voteRecordMapper.addRecord(voteRecord);
                if (row == 1)
                    row = optionMapper.updateOptionChooseNum(voteRecord.getOptionId());
                else
                    throw new UnknownException("增加投票记录失败");
                if (row != 1)
                    throw new UnknownException("更新选项数据失败");
            }
        }
        else if (type == 3){

            for (VoteRecord voteRecord: voteRecords
                    ) {

                if (voteRecord == null)
                    break;


                if (voteRecord.getValue()<0 || voteRecord.getValue()>10){
                    throw new FormErrorException("投票分数控制在十分之内");
                }

                voteRecord.setVoteId(voteId);
                voteRecord.setCreateAt(now);
                voteRecord.setUpdateAt(now);
                voteRecord.setUserId(userId);

                int row = voteRecordMapper.addRecord(voteRecord);
                if (row == 1)
                    row = optionMapper.updateOptionChooseNum(voteRecord.getOptionId());
                else
                    throw new UnknownException("增加投票记录失败");
                if (row == 1)
                    row = optionMapper.updateOptionValue(voteRecord.getOptionId(),voteRecord.getValue());
                else
                    throw new UnknownException("更新投票信息错误");
                if (row != 1)
                    throw new UnknownException("更新投票分数错误");
            }
        }
        else if (type == 4){

            for (VoteRecord voteRecord: voteRecords
                    ) {
                if (voteRecord.getValue()<0 || voteRecord.getValue()>100)
                    throw new FormErrorException("投票分数控制在百分之内");

                voteRecord.setVoteId(voteId);
                voteRecord.setCreateAt(now);
                voteRecord.setUpdateAt(now);
                voteRecord.setUserId(userId);

                int row = voteRecordMapper.addRecord(voteRecord);
                if (row == 1)
                    row = optionMapper.updateOptionChooseNum(voteRecord.getOptionId());
                else
                    throw new UnknownException("增加投票记录失败");
                if (row == 1)
                    row = optionMapper.updateOptionValue(voteRecord.getOptionId(),voteRecord.getValue());
                else
                    throw new UnknownException("更新投票信息错误");
                if (row != 1)
                    throw new UnknownException("更新投票分数错误");
            }
        }

        //参与人数加1
       int row = voteMapper.updateVoteParticipatorNum(voteId);
        if (row != 1)
            throw new UnknownException("更新参与人数失败");

        return true;
    }

    @Override
    public List<VoteNeed> haveVoted(long userId,int page, int rows) throws VoteNotExistException {
        PageHelper.startPage(page, rows);

        List<VoteNeed> votes = voteMapper.haveVoted(userId);
        long now = Utils.createTimeStamp();

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
    public List<VoteRecord> UserValue(long userId, Vote vote) {
        if (vote.getType() < 3){
            List<VoteRecord> records = voteRecordMapper.findRecord(vote.getId(),userId);
            return records;
        }
        else
            return voteRecordMapper.findThisUserValue(vote.getId(),userId);
    }
}
