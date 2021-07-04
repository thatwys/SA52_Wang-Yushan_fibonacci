package com.cloud.rest.common.exception;

import com.cloud.rest.common.bean.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * exception handling
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean handle(Exception e) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-1);
        resultBean.setMsg(e.getMessage());
        return resultBean;
    }
}