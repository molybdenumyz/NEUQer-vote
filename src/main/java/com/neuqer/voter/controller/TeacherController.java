package com.neuqer.voter.controller;

import com.neuqer.voter.common.Response;
import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.Derecord;
import com.neuqer.voter.domain.Maring;
import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.VoteNeed;
import com.neuqer.voter.dto.request.TeaSubmitRequest;
import com.neuqer.voter.dto.response.TeaIndexResponse;
import com.neuqer.voter.dto.response.TeaMaringResponse;
import com.neuqer.voter.dto.response.TeaSubmitResponse;
import com.neuqer.voter.service.RelationService;
import com.neuqer.voter.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RelationService relationService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public Response index(HttpServletRequest request,@RequestParam(required = false,defaultValue = "1") int page,
                          @RequestParam(required = false,defaultValue = "4") int rows){
        User user = (User)request.getAttribute("user");

        List<VoteNeed> votes = teacherService.allVoteToTeacher(user.getId(),page,rows);

        TeaIndexResponse teaIndexResponse = new TeaIndexResponse(votes);
        return new Response(0,teaIndexResponse);
    }

    @RequestMapping(path = "/{voteId}/info",method = RequestMethod.GET)
    public Response info (HttpServletRequest request,@PathVariable("voteId") long voteId){
        User user = (User)request.getAttribute("user");

        List<Maring> marings = teacherService.MaringToVote(voteId);

        TeaMaringResponse teaMaringResponse = new TeaMaringResponse(marings);

        return new Response(0,teaMaringResponse);
    }

    @Transactional
    @RequestMapping(path = "/{voteId}/submit",method = RequestMethod.POST)
    public Response submit (HttpServletRequest httpServletRequest, @RequestBody TeaSubmitRequest teaSubmitRequest,@PathVariable("voteId") long voteId){
        User user = (User) httpServletRequest.getAttribute("user");

        long proId = relationService.getProjectIdByVoteId(voteId);

        for (Maring maring:teaSubmitRequest.getOptions()
             ) {
            Derecord derecord = new Derecord();

            long now = Utils.createTimeStamp();

            derecord.setCreateAt(now);

            derecord.setValue(maring.getScore());

            derecord.setMaringId(maring.getId());

            derecord.setProjectId(proId);

            derecord.setVoteId(voteId);

            derecord.setUserId(user.getId());
            teacherService.SubmitToDerecord(derecord);
        }

        TeaSubmitResponse response = new TeaSubmitResponse(teaSubmitRequest.getOptions());
        return new Response(0,response);
    }

}
