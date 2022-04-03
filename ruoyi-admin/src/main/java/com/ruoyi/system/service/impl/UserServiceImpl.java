package com.ruoyi.system.service.impl;

import com.ruoyi.system.Utils.jdbcUtils;
import com.ruoyi.system.domain.FactoryDao;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.domain.unitDao;
import com.ruoyi.system.service.UserService;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
	// 工厂类
	unitDao userDao = FactoryDao.getUserDao();
	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	@Override
	public int updateUserById(User user) {
		return userDao.updateUserById(user);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	/**
	 * 支持事务处理
	 * @param id
	 * @return
	 */
	@Override
	public User getTransation(int id) {
		Connection conn = null;
		User user = null;
		try {
			// 获取
			conn = jdbcUtils.getConnection();
			// 开启
			conn.setAutoCommit(false);
			user = userDao.get(conn,id);
			// 结束
			conn.commit();
		}catch (Exception e){
			// 回滚
			jdbcUtils.rollbackTransation(conn);
		}
		return user;
	}

	@Override
	public List<User> getListAll() {
		return userDao.getListAll();
	}

	@Override
	public long getCountByName(String username) {
		return userDao.getCountByName(username);
	}

	/**
	 * 模糊查询
	 * @param username
	 * @param address
	 * @param phoneNo
	 * @return
	 */
	@Override
	public List<User> query(String username, String address, String phoneNo) {
		// 将参数传给Dao层
		return userDao.query(username,address,phoneNo);
	}
}
