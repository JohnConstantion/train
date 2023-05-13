package com.john.train.business.req;

import com.john.train.common.req.PageReq;

public class DailyTrainSeatQueryReq extends PageReq {

    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DailyTrainSeatQueryReq{");
        sb.append("trainCode='").append(trainCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}