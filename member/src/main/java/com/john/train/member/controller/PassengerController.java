package com.john.train.member.controller;

import com.john.train.common.resp.CommonResp;
import com.john.train.common.resp.PageResp;
import com.john.train.member.req.PassengerQueryReq;
import com.john.train.member.req.PassengerSaveReq;
import com.john.train.member.resp.PassengerQueryResp;
import com.john.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author johnconstantine
 */
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveReq req) {
        passengerService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryResps(@Valid PassengerQueryReq req) {
        PageResp<PassengerQueryResp> list = passengerService.queryResp(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        passengerService.delete(id);
        return new CommonResp<>();
    }
}
