package com.ruoyi.system.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class jdbcUtils{
	// 数据库连接池
	private static DataSource dataSource = null;
	// 静态代码块只会执行一次,数据库连接池只能有一个
	static {
		// 实例化连接池
		dataSource = new ComboPooledDataSource("mysql");
	}
	/**
	 * 获取到数据库MySQL的数据连接对象conn
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			// 获取数据库连接
			conn = dataSource.getConnection();
			// 返回连接
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接对象
	 * @param conn
	 */
	public static void closeConn(Connection conn){
		if (conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollbackTransation(Connection conn){
		if (conn!=null){
			try {
				// 回滚
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
