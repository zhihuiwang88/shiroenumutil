package com.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 只能处理Controller层未捕获(往外抛)的异常，不会拦截Interceptor的异常
 * @author Dell
 *
 */

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UnifyException.class)
	@ResponseBody
	public String handleServiceException(UnifyException e) {
		   e.printStackTrace();
 	return e.getMessage();
	}
	
}
