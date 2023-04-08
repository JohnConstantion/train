package com.john.train.member.controller;

import com.john.train.common.resp.CommonResp;
import com.john.train.member.req.MemberLoginReq;
import com.john.train.member.req.MemberRegisterReq;
import com.john.train.member.req.MemberSendCodeReq;
import com.john.train.member.resp.MemberLoginResp;
import com.john.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johnconstantine
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(count);
        return commonResp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
        return new CommonResp<>(register);
    }

    @PostMapping("/sendCode")
    public CommonResp<Long> sendCode(@Valid MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid MemberLoginReq req) {
        MemberLoginResp memberLoginResp = memberService.login(req);
        return new CommonResp<>(memberLoginResp);
    }
}
