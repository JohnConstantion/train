package com.john.train.member.service;

import com.john.train.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author johnconstantine
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper mapper;

    public Integer count() {
        return mapper.count();
    }
}
