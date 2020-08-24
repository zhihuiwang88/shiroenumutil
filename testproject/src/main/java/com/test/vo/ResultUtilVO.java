package com.test.vo;

import com.test.enums.ResultEnum;
import com.test.utils.ResultUtil;

public class ResultUtilVO {

	
	
	
	@SuppressWarnings("rawtypes")
	private static  ResultUtil resultUtil = new ResultUtil();
	/*
	 * 
	 * @param resultData
	 * @return 返回成功对象信息
	 */
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static  ResultUtil succeedData(Object resultData) {
		resultUtil.setCode(ResultEnum.SUCCESS.getCode());  
		resultUtil.setMsg(ResultEnum.SUCCESS.getMsg());
		resultUtil.setResultData(resultData);
		return resultUtil;
	}
	
	/*
	 * 返回成功信息：code 和 msg
	 */
	public static ResultUtil succeedCodeAndMsg() {
		return succeedData(null);
	}
	
	/*
	 * @param code 状态码
	 * @param msg 信息
	 * @return
	 */
	public static ResultUtil errorCodeAndMsg(Integer code,String msg) {
		resultUtil.setCode(code);
		resultUtil.setMsg(msg);
		return resultUtil;
	}
	
	
	
	
}
