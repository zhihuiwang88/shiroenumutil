package com.test.dao;

import java.util.List;

import com.test.entity.SysUser;

public interface SysUserDao {

	List<String> findUserPermissions(Integer id);
	SysUser findObjectByUserName(String username);
}
