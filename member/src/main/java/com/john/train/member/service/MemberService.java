package com.john.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.john.train.member.domain.Member;
import com.john.train.member.domain.MemberExample;
import com.john.train.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author johnconstantine
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper mapper;

    public int count() {
        return Math.toIntExact(mapper.countByExample(null));
    }

    public long register(String mobile) {
        MemberExample mobileExample = new MemberExample();
        mobileExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> mobiles = mapper.selectByExample(mobileExample);
        if (CollUtil.isNotEmpty(mobiles)) {
            // return list.get(0).getId();
            throw new RuntimeException("手机号已注册");
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        mapper.insert(member);
        return member.getId();
    }
}
