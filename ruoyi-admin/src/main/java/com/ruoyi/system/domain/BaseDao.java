package com.ruoyi.system.domain;

import com.ruoyi.system.Utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
	// insert，update，delete
	QueryRunner queryRunner = new QueryRunner();
	// 类信息
	private Class<T> aClass;
	/**
	 * 查询数据表
	 * 不支持事物
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object... args){
		Connection conn = null;
		T entity = null;
		try {
			// 连接
			conn = jdbcUtils.getConnection();
			// 查询
			entity = queryRunner.query(conn,sql, new BeanHandler<T>(aClass),args);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			// 关闭
			jdbcUtils.closeConn(conn);
		}
		return entity;
	}

	/**
	 * 支持事务的处理
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(Connection conn,String sql,Object... args){
		T entity = null;
		try {
			// 查询
			entity = queryRunner.query(conn,sql, new BeanHandler<T>(aClass),args);
		}catch (Exception e){
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * 获取多条记录
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getList(String sql, Object... args){
		Connection conn = null;
		// 结果
		List<T> list = new ArrayList<>();
		try {
			// 连接
			conn = jdbcUtils.getConnection();
			// 查询
			list = queryRunner.query(conn,sql, new BeanListHandler<>(aClass),args);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			// 关闭
			jdbcUtils.closeConn(conn);
		}
		return list;
	}

	/**
	 * 实现增删改的通用方法
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql,Object... args){
		Connection conn = null;
		// 条数
		int rows = 0;
		try {
			// 连接
			conn = jdbcUtils.getConnection();
			// 执行
			rows = queryRunner.update(conn,sql,args);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			// 关闭
			jdbcUtils.closeConn(conn);
		}
		return rows;
	}

	/**
	 * 查询结果只有一个数值类型,用户个数
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object getValue(String sql,Object... args){
		Connection conn = null;
		Object obj = null;
		try {
			// 连接
			conn = jdbcUtils.getConnection();
			// 修改
			obj = queryRunner.query(conn,sql,new ScalarHandler<>(),args);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			// 关闭
			jdbcUtils.closeConn(conn);
		}
		return obj;
	}
}
