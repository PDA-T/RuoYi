package com.ruoyi.system.service.impl;

import com.ruoyi.system.service.UserService;

public class FactoryService {
	public static UserService getUserService(){
		return new UserServiceImpl();
	}
}
