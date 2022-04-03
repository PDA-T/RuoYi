package com.ruoyi.system.domain;

public class FactoryDao {
	public static unitDao getUserDao(){
		return new UserDaoImpl();
	}
}
