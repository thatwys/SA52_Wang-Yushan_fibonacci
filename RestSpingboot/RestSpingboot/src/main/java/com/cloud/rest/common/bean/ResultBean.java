package com.cloud.rest.common.bean;

import com.cloud.rest.common.aop.IErrorMsg;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable, IErrorMsg {

    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int CHECK_FAIL = 1;

    public static final int NO_PERMISSION = 2;

    public static final int UNKNOWN_EXCEPTION = -99;

    /**
     * return message when things go wrong
     */
    private String msg = "success";

    /**
     * 0   : success
     * >0 : exception which known
     * <0 : exception which unknown
     */
    private int code = SUCCESS;

    /**
     * return data
     */
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = UNKNOWN_EXCEPTION;
    }
}
