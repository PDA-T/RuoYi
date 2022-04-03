package com.ruoyi.system.domain;

import java.sql.Connection;
import java.util.List;

public interface unitDao {
	/**
	 * 插入
	 * @param user
	 * @return
	 */
	public int save(User user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateUserById(User user);

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public User get(int id);

	/**
	 * 支持事务
	 * @param conn
	 * @param id
	 * @return
	 */
	public User get(Connection conn, int id);

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
