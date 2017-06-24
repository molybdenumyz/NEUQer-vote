package com.neuqer.voter.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.zxing.WriterException;
import com.neuqer.voter.common.Response;
import com.neuqer.voter.domain.*;
import com.neuqer.voter.dto.request.SubmitRequest;
import com.neuqer.voter.dto.response.EnCodeResponse;
import com.neuqer.voter.dto.response.VoteInfoResponse;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.Vote.FormErrorException;
import com.neuqer.voter.exception.Vote.VoteNotExistException;
import com.neuqer.voter.service.OptionService;
import com.neuqer.voter.service.QRCodeService;
import com.neuqer.voter.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by yinzhe on 17/5/13.
 */
@RestController
@RequestMapping("/vote")
public class VoteController {

   @Autowired
    VoteService voteService;

   @Autowired
    OptionService optionService;

   @Autowired
   QRCodeService qrCodeService;

    /**
     * 获取单个投票详细信息
     *
     * @param request
     * @return
     * @throws BaseException
     */
    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public Response getVoteInfo(HttpServletRequest request) throws BaseException {
        User user = (User) request.getAttribute("user");
        long voteId = 0;

        try{
           voteId = Long.parseLong(request.getParameter("voteId"));
        }catch (Exception e){
            throw new FormErrorException("show me voteId");
        }

        Vote vote = voteService.getVoteInfo(voteId);

        List<Option> options = optionService.listOptions(voteId);

        if (user != null){
            if (vote.getType() > 2){
                List<VoteRecord> records = voteService.UserValue(user.getId(),vote);

                VoteInfoResponse response = new VoteInfoResponse(vote,options,records);

                return new Response(0,response);
            }
            if (vote.getType() < 3){
                List<VoteRecord> records = voteService.UserValue(user.getId(),vote);

                for (Option option:options
                     ) {
                    for (VoteRecord record:records){
                        if (record.getOptionId() != option.getId())
                            continue;
                        else {
                            option.setValue(1);
                            break;
                        }
                    }
                }
                VoteInfoResponse response = new VoteInfoResponse(vote,options,null);
                return new Response(0,response);
            }
        }

        VoteInfoResponse response = new VoteInfoResponse(vote,options,null);

        return new Response(0,response);
    }

    @RequestMapping(path = "all",method = RequestMethod.GET)
    public Response getAllVote(HttpServletRequest request,
                               @RequestParam(required = false,defaultValue = "1") int page,
                               @RequestParam(required = false,defaultValue = "4") int rows) throws BaseException{

        List<VoteNeed> votes = voteService.getAllVote(page, rows);
        PageInfo response = new PageInfo<VoteNeed>(votes);

        return new Response(0,response);
    }


    @Transactional
    @RequestMapping(path = "/{voteId}/submit" ,method = RequestMethod.POST)
    public Response submit(@PathVariable("voteId") long voteId,@RequestBody SubmitRequest submitRequest,HttpServletRequest request) throws  BaseException{

        User user = (User) request.getAttribute("user");

        if (!voteService.submitVote(voteId,user.getId(),submitRequest.getRecords()))
            throw new UnknownException("提交投票错误");

        return new Response(0,null);
    }



    @RequestMapping(path = "haveVoted",method = RequestMethod.GET)
    public Response haveVoted(HttpServletRequest request,@RequestParam(required = false,defaultValue = "1") int page,
                              @RequestParam(required = false,defaultValue = "4") int rows) throws VoteNotExistException {

        User user = (User) request.getAttribute("user");

        long userId = user.getId();

        List<VoteNeed> voteList = voteService.haveVoted(userId,page,rows);

        PageInfo response = new PageInfo<VoteNeed>(voteList);

        return new Response(0,response);
    }


    @RequestMapping(path = "/{voteId}/encode", method = RequestMethod.POST)
    public Response enCode(@PathVariable("voteId") long voteId, @RequestBody JSONObject jsonObject) throws BaseException, IOException, WriterException {
        String path = "";
        String url = "";

           url  = jsonObject.getString("url");
            if (url == null)
                throw new FormErrorException("show me url");

     path = qrCodeService.EnCode(voteId, url);
     EnCodeResponse response = new EnCodeResponse(path);

        return new Response(0, response);
    }


}
