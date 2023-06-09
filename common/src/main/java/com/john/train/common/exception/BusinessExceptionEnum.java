package com.john.train.common.exception;

/**
 * @author johnconstantine
 */

public enum BusinessExceptionEnum {
    /**
     * 手机号已注册
     */
    MEMBER_MOBILE_EXIST("手机号已注册"),
    /**
     * 请先获取短信验证码
     */
    MEMBER_MOBILE_NOT_EXIST("请先获取短信验证码"),
    /**
     * 短信验证码错误
     */
    MEMBER_MOBILE_CODE_ERROR("短信验证码错误"),

    /**
     * 车站已存在
     */
    BUSINESS_STATION_NAME_UNIQUE_ERROR("车站已存在"),
    BUSINESS_TRAIN_CODE_UNIQUE_ERROR("车次编号已存在"),
    BUSINESS_TRAIN_STATION_INDEX_UNIQUE_ERROR("同车次站序已存在"),
    BUSINESS_TRAIN_STATION_NAME_UNIQUE_ERROR("同车次站名已存在"),
    BUSINESS_TRAIN_CARRIAGE_INDEX_UNIQUE_ERROR("同车次厢号已存在");;
    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" + "desc='" + desc + '\'' + "} " + super.toString();
    }
}
