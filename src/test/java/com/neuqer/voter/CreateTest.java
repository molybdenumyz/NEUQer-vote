package com.neuqer.voter;

import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteMaringRelation;
import com.neuqer.voter.domain.VoteTeacherRelation;
import com.neuqer.voter.mapper.RelationMapper;
import com.neuqer.voter.mapper.TeacherMapper;
import com.neuqer.voter.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Created by yinzhe on 17/6/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateTest {
    @Autowired
    private RelationMapper relationMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        String base = "abcdefghijklmnopqrstuvwxyz123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test1(){
        VoteTeacherRelation voteTeacherRelation = new VoteTeacherRelation();
//
//        voteTeacherRelation.setVoteId(100);
//
//        voteTeacherRelation.setUserId(70);
//
//        relationMapper.createVoteTeacherRelation(voteTeacherRelation);

        VoteMaringRelation voteMaringRelation = new VoteMaringRelation();
        voteMaringRelation.setVoteId(100);
        voteMaringRelation.setMaringId(1);

        relationMapper.createVoteMaringRelation(voteMaringRelation);

        voteTeacherRelation.setUserId(70);
        voteTeacherRelation.setVoteId(99);
        relationMapper.createVoteTeacherRelation(voteTeacherRelation);



        System.out.println(teacherMapper.getVoteByUserId(70));
    }

}
