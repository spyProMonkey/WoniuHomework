package com.woniu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	static ComboPooledDataSource source = new ComboPooledDataSource();
	
	public static Connection getConn() throws SQLException{
		return source.getConnection();
	}
	
	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
		if(rs!=null){
				rs.close();
			} 
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
