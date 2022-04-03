package com.ruoyi.system.domain;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements unitDao{
	@Override
	public int save(User user) {
		String sql = "INSERT INTO gar_clean_unit (city, region, street, region_code, address, alias, unit_name, contacts, contacts_phone, remarks, lon, lat, create_time, create_by, update_time, update_by, del_flag, status, unit_type, unit_leibie, license_no, car_url) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		// 插入
		return super.update(sql,user.getCuid(),user.getCity(),user.getRegion(),user.getStreet(),user.getRegionCode(),user.getAddress(),user.getAlias(),user.getUnitName(),user.getContacts(),user.getContactsPhone(),user.getRemarks(),user.getLon(),user.getLat(),user.getDelFlag(),user.getStatus(),user.getUnitType(),user.getUnitLeibie(),user.getLicenseNo(),user.getCarUrl());
	}

	@Override
	public int deleteUserById(int id) {
		String sql = "DELETE FROM gar_clean_unit WHERE city=?;";
		// 删除
		return super.update(sql,id);
	}

	@Override
	public int updateUserById(User user) {
		String sql = "UPDATE gar_clean_unit SET city=?, region=?, street=?, region_code=?, address=?, alias=?, unit_name=?, contacts=?, contacts_phone=?, remarks=?, lon=?, lat=?, create_time=?, create_by=?, update_time=?, update_by=?, del_flag=?, status=?, unit_type=?, unit_leibie=?, license_no=?, car_url=?;";
		// 修改
		return super.update(sql,user.getCuid(),user.getCity(),user.getRegion(),user.getStreet(),user.getRegionCode(),user.getAddress(),user.getAlias(),user.getUnitName(),user.getContacts(),user.getContactsPhone(),user.getRemarks(),user.getLon(),user.getLat(),user.getDelFlag(),user.getStatus(),user.getUnitType(),user.getUnitLeibie(),user.getLicenseNo(),user.getCarUrl());
	}

	/**
	 * 不支持事务
	 * @param id
	 * @return
	 */
	@Override
	public User get(int id) {
		// sql
		String sql = "SELECT * FROM gar_clean_unit WHERE city=?;";
		return super.get(sql,id);
	}

	/**
	 * 支持事务
	 * @param conn
	 * @param id
	 * @return
	 */
	@Override
	public User get(Connection conn, int id) {
		// sql
		String sql = "SELECT * FROM gar_clean_unit WHERE city=?;";
		return super.get(conn,sql,id);
	}

	@Override
	public List<User> getListAll() {
		String sql = "SELECT * FROM gar_clean_unit;";
		// 所有的记录
		return super.getList(sql);
	}

	@Override
	public long getCountByName(String username) {
		String sql = "SELECT COUNT(id) FROM gar_clean_unit WHERE username=?;";
		// 获取单个用户有几条记录
		return (long) super.getValue(sql,username);
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
		String sql = "SELECT city, region, street, region_code, address, alias, unit_name, contacts, contacts_phone, remarks, lon, lat, create_time, create_by, update_time, update_by, del_flag, status, unit_type, unit_leibie, license_no, car_url WHERE 1=1";
		// 不是空并且不是空字符串
		if (username != null && !"".equals(username)){
			// 添加新条件
			sql = sql + " AND username like '%"+username+"%';";
		}
		if (address != null && !"".equals(address)){
			sql = sql + " AND address like '%"+address+"%';";
		}
		if (phoneNo != null && !"".equals(phoneNo)){
			sql = sql + " AND phone_no like '%"+phoneNo+"%';";
		}
		// 执行
		return super.getList(sql);
	}
}
