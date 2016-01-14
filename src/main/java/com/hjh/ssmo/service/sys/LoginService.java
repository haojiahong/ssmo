package com.hjh.ssmo.service.sys;

import com.hjh.ssmo.model.sys.Manager;

public interface LoginService {

	public boolean validateManager(Manager manager);

	public Manager getManagerInfo(Manager manager);

	public Manager getManagerByUsername(String username);

}
