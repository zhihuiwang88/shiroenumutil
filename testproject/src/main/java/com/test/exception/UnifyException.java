package com.test.exception;

import com.test.enums.ResultEnum;

public class UnifyException extends RuntimeException{

	/**
	 * 统一异常
	 */
	private static final long serialVersionUID = 163355994535623212L;

	
	
	public UnifyException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
	}

    public UnifyException(String message,Throwable throwable) {
    	super(message, throwable);
    }

	public UnifyException(String message) {
		super(message);
	}
	
	public UnifyException(Throwable throwable) {
		super(throwable);
	}
	
	public UnifyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
