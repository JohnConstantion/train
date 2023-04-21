package com.john.train.member.controller;

import com.john.train.common.resp.CommonResp;
import com.john.train.common.resp.PageResp;
import com.john.train.member.req.${Domain}QueryReq;
import com.john.train.member.req.${Domain}SaveReq;
import com.john.train.member.resp.${Domain}QueryResp;
import com.john.train.member.service.${Domain}Service;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author johnconstantine
 */
@RestController
@RequestMapping("/${do_main}")
public class ${Domain}Controller {
    @Resource
    private ${Domain}Service ${domain}Service;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody ${Domain}SaveReq req) {
        ${domain}Service.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<${Domain}QueryResp>> queryResps(@Valid ${Domain}QueryReq req) {
        PageResp<${Domain}QueryResp> list = ${domain}Service.queryResp(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        ${domain}Service.delete(id);
        return new CommonResp<>();
    }
}
