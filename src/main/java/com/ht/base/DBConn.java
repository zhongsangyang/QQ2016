package com.ht.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static String driver = "com.mysql.jdbc.Driver"; //驱动
	private static String url="jdbc:mysql://localhost:3306/qq?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	private static String username="root";
	private static String password="mysql";
	private static Connection conn=null;
	//静态语句块，连接数据库
	static{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//连接数据库
	public static Connection openDB(){
		try {
			//判断连接状态
			if(conn.isClosed()){
				conn = DriverManager.getConnection(url,username,password);
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		
	}
}
