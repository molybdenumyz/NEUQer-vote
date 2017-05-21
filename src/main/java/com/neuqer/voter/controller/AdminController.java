package com.neuqer.voter.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.neuqer.voter.common.Excel;
import com.neuqer.voter.common.Response;
import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.*;
import com.neuqer.voter.dto.request.*;
import com.neuqer.voter.dto.response.*;
import com.neuqer.voter.exception.Auth.NoPermissonException;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.Option.OptionNotBelongToVoteException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.Vote.FormErrorException;
import com.neuqer.voter.exception.Vote.TimeErrorException;
import com.neuqer.voter.exception.Vote.VoteNotExistException;
import com.neuqer.voter.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinzhe on 17/5/9.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private TokenService tokenService;

    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    final static int MAX_NUMBER = 100;

    /**
     * 创建投票
     *
     * @param request
     * @param voteCreateRequest
     * @return
     * @throws BaseException
     */
    @Transactional
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Response createVote(HttpServletRequest request, @RequestBody @Valid VoteCreateRequest voteCreateRequest) throws BaseException {
        User user = (User) request.getAttribute("user");

        boolean admin = adminService.isAdmin(user.getId());

        if (!admin) {
            throw new NoPermissonException();
        }

        long now = Utils.createTimeStamp();

        if (now > voteCreateRequest.getStartTime())
            throw new TimeErrorException("开始时间需大于当前时间");

        if (voteCreateRequest.getEndTime() < voteCreateRequest.getStartTime())
            throw new TimeErrorException("开始时间应小于结束时间");

        Vote vote = new Vote();
        vote.setTitle(voteCreateRequest.getTitle());
        vote.setStartTime(voteCreateRequest.getStartTime());
        vote.setEndTime(voteCreateRequest.getEndTime());


        vote.setType(voteCreateRequest.getType());
        if (voteCreateRequest.getType() == 1)
            vote.setMax(1);
        else if (voteCreateRequest.getType() == 2)
            vote.setMax(voteCreateRequest.getMax());
        else
            vote.setMax(MAX_NUMBER);
        vote.setParticipatorLimit(10000);


        vote.setPassword(null);
        vote.setDescription(null);
        vote.setVisibilityLimit(true);
        vote.setAnonymous(false);
        vote = adminService.createVote(user.getId(), vote);

        List<String> optionCreateRequests = voteCreateRequest.getOptions();

        List<Option> options = new ArrayList<>();
        for (String optionCreateRequest : optionCreateRequests) {
            Option newOption = new Option();
            newOption.setTitle(optionCreateRequest);
            newOption.setVoteId(vote.getId());
            newOption.setValue(0);
            options.add(newOption);
        }
        optionService.createOption(user.getId(), vote.getId(), options);

        VoteCreateResponse response = new VoteCreateResponse(vote, optionCreateRequests);

        return new Response(0, response);
    }

    /**
     * 获取单个投票详细信息
     *
     * @param voteId
     * @param request
     * @return
     * @throws BaseException
     */
    @RequestMapping(path = "/{voteId}/info", method = RequestMethod.GET)
    public Response getVoteInfo(@PathVariable("voteId") long voteId, HttpServletRequest request) throws BaseException {

        User user = (User) request.getAttribute("user");
        boolean admin = adminService.isAdmin(user.getId());

        if (!admin) {
            throw new NoPermissonException();
        }

        Vote vote = adminService.getVoteInfo(voteId);

        List<Option> options = optionService.listOptions(voteId);


        VoteInfoResponse response = new VoteInfoResponse(vote, options);

        return new Response(0, response);
    }

    /**
     * 获取用户创建的投票列表
     *
     * @param request
     * @return
     * @throws BaseException
     */
    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public Response getVotesInfo(HttpServletRequest request,
                                 @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "6") int rows) throws BaseException {
        User user = (User) request.getAttribute("user");
        boolean admin = adminService.isAdmin(user.getId());
        if (!admin) {
            throw new NoPermissonException();
        }

        List<VoteNeed> votes = adminService.getAllVote(page, rows);

        PageInfo response = new PageInfo<VoteNeed>(votes);
        return new Response(0, response);
    }


    /**
     * 删除投票
     *
     * @param voteId
     * @param request
     * @return
     * @throws BaseException
     */
    @RequestMapping(path = "/{voteId}/delete", method = RequestMethod.DELETE)
    public Response deleteVote(@PathVariable("voteId") long voteId, HttpServletRequest request) throws BaseException {
        User user = (User) request.getAttribute("user");
        boolean admin = adminService.isAdmin(user.getId());

        if (!admin) {
            throw new NoPermissonException();
        }
        adminService.deleteVote(voteId);

        return new Response(0, null);
    }

    /**
     * 生成投票二维码
     *
     * @param voteId
     * @param jsonObject
     * @return
     */
    @RequestMapping(path = "/{voteId}/encode", method = RequestMethod.POST)
    public Response enCode(@PathVariable("voteId") long voteId, @RequestBody JSONObject jsonObject) {

        String path = qrCodeService.EnCode(voteId, jsonObject.getString("url"));
        EnCodeResponse response = new EnCodeResponse(path);
        return new Response(0, response);
    }

    /**
     * 投票可见状态
     *
     * @param voteId
     * @param request
     * @param jsonRequest
     * @return
     * @throws BaseException
     */
    @RequestMapping(path = "/{voteId}/changeVisibility", method = RequestMethod.PUT)
    public Response changeVisibility(@PathVariable("voteId") long voteId, HttpServletRequest request, @RequestBody JSONObject jsonRequest) throws BaseException {
        User user = (User) request.getAttribute("user");
        boolean admin = adminService.isAdmin(user.getId());

        if (!admin) {
            throw new NoPermissonException();
        }
        if (!adminService.disVisibility(voteId)) {
            throw new UnknownException();
        }
        return new Response(0, null);
    }

    /**
     * 登陆后台
     *
     * @param request
     * @return
     * @throws BaseException
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody @Valid AdminLoginRequest request) throws BaseException {

        User user = adminService.loginAdmin(request.getMobile(), request.getPassword());
        Token token = tokenService.generateToken(user.getId(), request.getClient(), "unknown");
        UserLoginResponse response = new UserLoginResponse(user, token.getToken());

        return new Response(0, response);
    }

    @RequestMapping(path = "/{voteId}/beforeUpdate", method = RequestMethod.GET)
    public Response beforeUpdate(@PathVariable("voteId") long voteId, HttpServletRequest request) throws BaseException {

        User user = (User) request.getAttribute("user");
        boolean admin = adminService.isAdmin(user.getId());

        if (!admin) {
            throw new NoPermissonException();
        }

        Vote vote = adminService.getVoteInfo(voteId);

        List<Option> options = optionService.listOptions(voteId);


        BeforeUpdateResponse response = new BeforeUpdateResponse(vote, options);

        return new Response(0, response);
    }

    @RequestMapping(path = "/updateVote", method = RequestMethod.POST)
    public Response updateVoteInfo(@RequestBody @Valid UpdateVoteInfoRequest request) throws BaseException {

        long userId = request.getCreatorId();
        boolean admin = adminService.isAdmin(userId);

        if (!admin)
            throw new NoPermissonException();
        long now = Utils.createTimeStamp();

        Vote vote = adminService.getVoteInfo(request.getId());
        if (request.getStartTime() != 0) {
            if (now > request.getStartTime())
                throw new TimeErrorException("开始时间设置有误");

            if ((now > vote.getStartTime()) && (vote.getStartTime() != request.getStartTime()))
                throw new TimeErrorException("投票已经开始，不能修改投票时间");

            if (request.getStartTime() > request.getEndTime())
                throw new TimeErrorException("开始时间应小于结束时间");
        }

        vote.setTitle(request.getTitle());
        vote.setStartTime(request.getStartTime());
        vote.setEndTime(request.getEndTime());
        for (Option option : request.getOptions()
                ) {
            if (option.getVoteId() != vote.getId())
                throw new OptionNotBelongToVoteException();
        }
        if (!adminService.updateVote(vote, request.getOptions()))
            throw new UnknownException();

        return new Response(0, null);
    }


    @RequestMapping(path = "/{voteId}/record", method = RequestMethod.GET)
    public Response record(@PathVariable("voteId") long voteId, HttpServletRequest request) throws BaseException {

        Vote vote = adminService.getVoteInfo(voteId);
        if (vote.getType() == 3 || vote.getType() == 4) {
            ValueRecordResponse response = adminService.valueRecord(vote);
            return new Response(0, response);
        }
        List<Option> options = adminService.record(vote);


        RecordsResponse recordsResponse = new RecordsResponse(vote, options);
        return new Response(0, recordsResponse);
    }


    @RequestMapping(path = "/{voteId}/download", method = RequestMethod.GET)
    public Response download(@PathVariable("voteId") long voteId) throws IOException, BaseException {
        Excel excel = new Excel();
        String path = "";
        Vote vote = adminService.getVoteInfo(voteId);
        if (vote.getType() == 1 || vote.getType() == 2) {
            List<Option> options = adminService.record(vote);
            RecordRequest request = new RecordRequest();
            request.setOptions(options);
            request.setId(vote.getId());
            request.setType(vote.getType());
            path = excel.objListToExcel(request);
        } else if (vote.getType() == 3 || vote.getType() == 4) {
            ValueRecordResponse response = adminService.valueRecord(vote);
            path = excel.ValueRecordExcel(response);
        }
        FilePathResponse filePathResponse = new FilePathResponse(path);
        return new Response(0, filePathResponse);
    }


    @RequestMapping(path = "/findLike", method = RequestMethod.POST)
    public Response findLike(@RequestBody @Valid FindLikeRequest findLikeRequest,HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "6") int rows) throws VoteNotExistException, NoPermissonException {
        User user = (User) request.getAttribute("user");

        boolean admin = adminService.isAdmin(user.getId());
        if (!admin) {
            throw new NoPermissonException();
        }
        System.out.println(findLikeRequest.getFlag());
        List<VoteNeed> votes = adminService.findLike(page,rows,findLikeRequest);

        PageInfo response = new PageInfo<VoteNeed>(votes);

        return new Response(0, response);

    }

}
