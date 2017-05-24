package com.neuqer.voter.service.impl;

import com.github.pagehelper.PageHelper;
import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.*;
import com.neuqer.voter.dto.request.FindLikeRequest;
import com.neuqer.voter.dto.response.OptionValue;
import com.neuqer.voter.dto.response.ValueRecordResponse;
import com.neuqer.voter.exception.Auth.NoPermissonException;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.User.PasswordErrorException;
import com.neuqer.voter.exception.User.UserNotExistException;
import com.neuqer.voter.exception.Vote.*;
import com.neuqer.voter.mapper.*;
import com.neuqer.voter.service.AdminService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinzhe on 17/5/10.
 */
@Service("AdminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper voteMapper;

    @Autowired
    private OptionMapper optionMapper;


    @Autowired
    private VoteRecordMapper voteRecordMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean isAdmin(long userId) {
        Integer id = voteMapper.isAdmin(userId);
        if (id != 2)
            return false;
        else
            return true;
    }

    @Override
    public boolean upToAdmin(long userId) {
        Integer row = voteMapper.upToAdmin(userId);
        if (row == 1)
            return true;
        else return false;
    }

    @Override
    public Vote getVoteInfo(long id) throws BaseException {
        Vote vote = voteMapper.getVote(id);
        if (vote == null) {
            throw new VoteNotExistException();
        } else {
            long now = Utils.createTimeStamp();

            if (now < vote.getStartTime())
                vote.setFlag(0);
            else if (vote.getStartTime() < now && vote.getEndTime() > now)
                vote.setFlag(1);
            else
                vote.setFlag(2);
        }
        return vote;
    }

    @Override
    public List<VoteNeed> getAllVote(int page,int rows) throws BaseException {
        PageHelper.startPage(page, rows);

        List<VoteNeed> votes = voteMapper.getAllVote();
        long now = Utils.createTimeStamp();

        if (votes == null) {
            throw new VoteNotExistException();
        }
        for (VoteNeed vote:votes
             ) {
            if (now < vote.getStartTime())
                vote.setFlag(0);
            else if (vote.getStartTime() < now && vote.getEndTime() > now)
                vote.setFlag(1);
            else
                vote.setFlag(2);
        }


        return votes;
    }

    @Override
    public Vote createVote(long userId, Vote vote) throws BaseException {
        Vote newVote = voteMapper.getVoteByTitle(vote.getTitle());

        if (newVote != null) {
            throw new VoteExistedException();
        }

        long currentTime = Utils.createTimeStamp();
        vote.setCreatedAt(currentTime);
        vote.setUpdatedAt(currentTime);
        vote.setCreatorId(userId);

        int row = voteMapper.createVote(vote);

        if (row != 1) {
            throw new UnknownException("Fail to create vote");
        } else {
            return vote;
        }
    }

    @Override
    public boolean deleteVote(long id) throws BaseException {


        if (voteMapper.deleteVote(id) < 1) {
            throw new UnknownException();
        } else {
           optionMapper.deleteOption(id);
            return true;
        }

    }


    @Override
    public boolean disVisibility(long voteId) throws VoteNotExistException {
        if (voteMapper.disVisibility(voteId) < 1) {
            throw new VoteNotExistException();
        }else {
            return  true;
        }
    }

    public User loginAdmin(String mobile, String password) throws BaseException {
        User user = userMapper.getUserByMobile(mobile);

        if (user == null) {
            throw new UserNotExistException();
        } else if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new PasswordErrorException();
        }
        if (user.getStatus() != 2)
            throw new NoPermissonException();
        return user;
    }

    @Override
    public boolean updateVote(Vote vote, List<Option> options) throws UnknownException {

        Integer row = voteMapper.updateVote(vote);
        if (row <1)
            throw new UnknownException("update Error");

        for (Option option:options
             ) {
            option.setVoteId(vote.getId());
            voteMapper.updateVoteOption(option);
            if (row <1)
                throw new UnknownException("update Error");
        }
        return  true;
    }

    @Override
    public List<Option> record(Vote vote) throws UnknownException {


        List<Option> optionList = optionMapper.listOptions(vote.getId());

        if (vote.getType() == 1 || vote.getType() == 2) //单多选题
        {


            for (Option option:optionList
                 ) {
                if (option.getNum() == 0)
                    option.setValue(0);
                if (option.getNum() > 0) {
                    int temp = option.getNum()*100 / vote.getParticipatorNum();
                    option.setValue(temp);
                }
             return optionList;
            }
        }
        else if (vote.getType() == 3 || vote.getType() == 4)// 十分制百分制
            return optionList;

        else
            throw new UnknownException("统计失败");

        return null;
    }

    @Override
    public ValueRecordResponse valueRecord(Vote vote) {
        ValueRecordResponse response = new ValueRecordResponse();
        
        response.setVoteId(vote.getId());
        response.setTitle(vote.getTitle());
        response.setType(vote.getType());
        

        
        List<Option> optionList = optionMapper.listOptions(vote.getId());

        List<OptionValue> optionValueList = new ArrayList<OptionValue>();
        for (Option option:optionList
             ) {
            List<Integer> voteRecords = voteRecordMapper.findUserValue(vote.getId(),option.getId());
            OptionValue tempValue = new OptionValue();
            tempValue.setId(option.getId());
            tempValue.setNum(option.getNum());
            tempValue.setSum(option.getValue());
            tempValue.setTitle(option.getTitle());
            tempValue.setVoteId(option.getVoteId());
            tempValue.setVoteRecords(voteRecords);
            OptionValue optionValue = tempValue;
            optionValueList.add(optionValue);
        }


       response.setOptionValue(optionValueList);

        return response;
    }

    @Override
    public List<VoteNeed> findLike(int page, int rows, FindLikeRequest request) throws VoteNotExistException {
        PageHelper.startPage(page, rows);

        long now = Utils.createTimeStamp();

        request.setNow(now);

        List<VoteNeed> votes = voteMapper.findLike(request);



        if (votes == null) {
            throw new VoteNotExistException();
        }
        int flag = request.getFlag();


            for (VoteNeed vote:votes
                    ) {
                if (now < vote.getStartTime())
                    vote.setFlag(0);
                else if (vote.getStartTime() < now && vote.getEndTime() > now)
                    vote.setFlag(1);
                else
                    vote.setFlag(2);
            }



        return votes;
    }
}
