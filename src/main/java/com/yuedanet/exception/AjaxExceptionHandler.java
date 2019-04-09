package com.yuedanet.exception;

import com.yuedanet.utils.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AjaxExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request,
                                          HttpServletResponse response,
                                          Exception e)throws Exception{
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());

    }
}
