package com.hjh.ssmo.mapper.sys;

import com.hjh.ssmo.model.sys.Manager;

public interface LoginMapper {

	int validateManager(Manager manager);

	Manager getManagerInfo(Manager manager);

}
