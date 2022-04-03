package com.ruoyi.system.service;

import com.ruoyi.system.domain.User;

import java.util.List;

public interface UserService {
	/**
	 * 插入信息
	 * @param user
	 * @return
	 */
	public int save(User user);

	/**
	 * 根据用户编号删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);

	/**
	 * 根据用户编号修改用户
	 * @param user
	 * @return
	 */
	public int updateUserById(User user);

	/**
	 * 根据用户编号查询单条记录,封装成User对象
	 * @param id
	 * @return
	 */
	public User get(int id);

	/**
	 * 支持事务
	 * @param id
	 * @return
	 */
	public User getTransation(int id);

	/**
	 * 获取所有用户记录
	 * @return
	 */
	public List<User> getListAll();

	/**
	 * 查询指定用户名的用户有多少条
	 * @param username
	 * @return
	 */
	public long getCountByName(String username);

	/**
	 * 模糊查询
	 * @param username
	 * @param address
	 * @param phoneNo
	 * @return
	 */
	List<User> query(String username, String address, String phoneNo);
}
