package com.test.enums;

/**
 * 通用枚举
 * @author Dell
 *
 */
public enum ResultEnum {
	
	
	
	SUCCESS(200,"成功"),
	ERROR(100,"失败"),
	
	;
	
	/*
	 * 状态码
	 */
	private Integer code;
	/*
	 * 信息
	 */
	private String msg;
	
	ResultEnum(Integer code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	

}
