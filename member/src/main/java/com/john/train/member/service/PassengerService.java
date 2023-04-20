package com.john.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.john.train.common.context.LoginMemberContext;
import com.john.train.common.util.SnowUtil;
import com.john.train.member.domain.Passenger;
import com.john.train.member.domain.PassengerExample;
import com.john.train.member.mapper.PassengerMapper;
import com.john.train.member.req.PassengerQueryReq;
import com.john.train.member.req.PassengerSaveReq;
import com.john.train.member.resp.PassengerQueryResp;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author johnconstantine
 */
@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

    public List<PassengerQueryResp> queryResp(PassengerQueryReq req) {
        PassengerExample example = new PassengerExample();
        PassengerExample.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotNull(req.getMemberId())) {
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        List<Passenger> passengerList = passengerMapper.selectByExample(example);
        return BeanUtil.copyToList(passengerList, PassengerQueryResp.class);
    }
}
