package com.test.controller;

import com.test.entity.User;
import com.test.enums.ResultEnum;
import com.test.utils.ResultUtil;
import com.test.vo.ResultUtilVO;

public class UserController {

	/**
	 * 根据用户名查询信息
	 * @param userName
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResultUtil findByName(String userName) {
		User user = new User();
		
		return ResultUtilVO.succeedData(user);
	}
	
	/**
	 * 删除ID
	 * @param id
	 * @return
	 */
	public ResultUtil removeById(Integer id) {
		if (id == null) {
			return ResultUtilVO.errorCodeAndMsg(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg());
		}
		return ResultUtilVO.succeedCodeAndMsg();
	}
	
	
	
	
}
