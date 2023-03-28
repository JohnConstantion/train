package com.john.train.common.exception;

/**
 * @author johnconstantine
 */
public class BusinessException extends RuntimeException {
    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessExceptionEnum getE() {
        return e;
    }

    public void setE(BusinessExceptionEnum e) {
        this.e = e;
    }
}
