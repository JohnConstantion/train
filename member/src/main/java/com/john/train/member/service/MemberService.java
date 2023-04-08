package com.john.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.john.train.common.exception.BusinessException;
import com.john.train.common.exception.BusinessExceptionEnum;
import com.john.train.common.util.SnowUtil;
import com.john.train.member.domain.Member;
import com.john.train.member.domain.MemberExample;
import com.john.train.member.mapper.MemberMapper;
import com.john.train.member.req.MemberLoginReq;
import com.john.train.member.req.MemberRegisterReq;
import com.john.train.member.req.MemberSendCodeReq;
import com.john.train.member.resp.MemberLoginResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author johnconstantine
 */
@Service
public class MemberService {

    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);
    @Resource
    private MemberMapper mapper;

    public int count() {
        return Math.toIntExact(mapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        Member memberDb = selectByDb(mobile);
        if (ObjectUtil.isNotNull(memberDb)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        mapper.insert(member);
        return member.getId();
    }

    public void sendCode(MemberSendCodeReq req) {
        String mobile = req.getMobile();
        Member memberDb = selectByDb(mobile);
        if (ObjectUtil.isNull(memberDb)) {
            LOG.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            mapper.insert(member);
        } else {
            LOG.info("手机号存在，不插入记录");
        }

        // 生成验证码 String code = RandomUtil.randomString(4);
        String code = "8888";
        LOG.info("生成短信验证码：{}", code);

        // 保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        LOG.info("保存短信记录表");

        // 对接短信通道，发送短信
        LOG.info("对接短信通道");
    }

    public MemberLoginResp login(MemberLoginReq req) {
        String reqMobile = req.getMobile();
        String reqCode = req.getCode();
        Member memberDb = selectByDb(reqMobile);
        if (ObjectUtil.isNull(memberDb)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }
        if (!"8888".equals(reqCode)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_ERROR);
        }
        return BeanUtil.copyProperties(memberDb, MemberLoginResp.class);
    }

    private Member selectByDb(String reqMobile) {
        MemberExample mobileExample = new MemberExample();
        mobileExample.createCriteria().andMobileEqualTo(reqMobile);
        List<Member> mobiles = mapper.selectByExample(mobileExample);
        if (CollUtil.isEmpty(mobiles)) {
            return null;
        }
        return mobiles.get(0);
    }
}
