package com.test.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.test.dao.SysUserDao;
import com.test.entity.SysUser;


public class ShiroUserRealm extends AuthorizingRealm{

	@Autowired
	private SysUserDao sysUserDao;
	
	private static final Logger log = LoggerFactory.getLogger(ShiroUserRealm.class);
	/**负责授权检测*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	       //1.获取用户权限(用户-->角色-->资源)
			//1.1获取用户信息(session)
			SysUser user = (SysUser)SecurityUtils.getSubject().getSession().getAttribute("user");
			//1.2根据用户信息获取资源的访问权限
			List<String> list=sysUserDao.findUserPermissions(user.getId());
			log.info("==-====list:" + list.size());
			//1.3去重复的权限
			Set<String> set = new HashSet<String>();
			for(String p:list){
				if(!StringUtils.isEmpty(p)){
					set.add(p);
				}
			}
			log.info("permissions="+set );
			//2.封装用户权限(AuthorizationInfo)
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setStringPermissions(set);
			return info;
	}

	/**此方法负责认证检测(检测用户身份是否存在,密码是否正确)
	 * 1)subject.login(token)-->
	 * 2)securityManager-->
	 * 3)Authentication--
	 * 4)ShiroUserRealm-->
	 * 5)doGetAuthenticationInfo
	 * */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       //1.获取用户名
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		String username = upToken.getUsername();
		//2.根据用户名查找用户对象
		SysUser user = sysUserDao.findObjectByUserName(username);
		//user.getUserName();
		//3.初始化SimpleAuthenticationInfo对象
		ByteSource saltSource = ByteSource.Util.bytes(user.getSalt().getBytes());
		log.info("name:" +user.getUserName()+",ps:"+user.getPassword()+",na:"+this.getName());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
		//用户身份 
		user.getUserName(),
		//已加密的密码
		user.getPassword(),
		//盐值对应的ByteSource
		saltSource, 
		//realm的名字
		getName());
		//4.存储用户信息(session)
		SecurityUtils.getSubject().getSession().setAttribute("user", user);
		log.info("====info:" + info);
		//此对象会给谁了?认证器对象
		return info;
	}


}
