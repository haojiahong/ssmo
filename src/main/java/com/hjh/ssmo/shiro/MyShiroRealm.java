package com.hjh.ssmo.shiro;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.hjh.ssmo.model.sys.Manager;
import com.hjh.ssmo.service.sys.LoginService;
import com.hjh.ssmo.util.Constant;

public class MyShiroRealm extends AuthorizingRealm {
	private LoginService loginService;

	// 获取权限信息
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		String currentUsername = (String) super.getAvailablePrincipal(principals);
		if (currentUsername != null) {
			SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
			// 查询用户授权信息

			// 超级管理员默认拥有所有操作权限
			if (Constant.SYSTEM_ADMINISTRATOR.equals(currentUsername)) {
				// 添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
				simpleAuthorInfo.addRole("admin");
				// 添加权限
				simpleAuthorInfo.addStringPermission("admin:manage");
				System.out.println("已为用户[" + currentUsername + "]赋予了[admin]角色和[admin:manage]权限");
				return simpleAuthorInfo;
			} else {
				System.out.println("当前用户[" + currentUsername + "]无授权");
				return simpleAuthorInfo;
			}
		}
		return null;
	}

	// 获取认证信息
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println("验证当前Subject时获取到token为"
				+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		Manager user = loginService.getManagerByUsername(token.getUsername());
		if (null != user) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),
					getName());
			this.setSession("currentUser", user);
			return authcInfo;
		} else {
			return null;
		}
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

}
