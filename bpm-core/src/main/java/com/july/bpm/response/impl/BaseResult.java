package com.july.bpm.response.impl;

import com.july.bpm.constant.BaseStatusCode;
import com.july.bpm.response.IResult;

/**
 * 基础返回结果
 *
 * @author Jeff
 */
public class BaseResult implements IResult {


    private static final long serialVersionUID = 6131673218827464899L;

    /**
     * 本次调用是否成功
     */
    private Boolean isOk;

    /**
     * 操作提示信息
     */
    private String msg;

    /**
     * 异常堆栈信息
     */
    private String cause;

    /**
     * 状态码
     */
    private String code;

    public void setOk(Boolean ok) {
    	if(ok) {
    		this.setCode(BaseStatusCode.SUCCESS.getCode());
    	}
        isOk = ok;
    }

    @Override
    public Boolean getIsOk() {
        return isOk;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }


    @Override
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
