package com.hjh.ssmo.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hjh.ssmo.mapper.sys.LoginMapper;
import com.hjh.ssmo.model.sys.Manager;
import com.hjh.ssmo.service.sys.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public boolean validateManager(Manager manager) {
		return loginMapper.validateManager(manager) > 0 ? true : false;
	}

	@Override
	public Manager getManagerInfo(Manager manager) {
		return loginMapper.getManagerInfo(manager);
	}

	/**
	 * shiro校验登陆使用
	 */
	@Override
	public Manager getManagerByUsername(String username) {
		return loginMapper.getManagerByUsername(username);
	}
}
