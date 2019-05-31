package com.woniu.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDAO<T> {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public void update(String sql, Object[] objs) {
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
			int rows = ps.executeUpdate();
			if (rows != 0) {
				System.out.println("ok影响的行数为："+rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeAll(null, ps, conn);
		}

	}

	public List<T> query(String sql, Object[] objs, Class c) {
		List<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				T t = (T) c.newInstance();
				Method[] m = c.getDeclaredMethods();
				for (int i = 0; i < m.length; i++) {
					String name = m[i].getName();
					Class[] type = m[i].getParameterTypes();
					if (name.startsWith("set")) {
						String fied = name.substring(3);
						if (type[0] == Integer.class) {
							m[i].invoke(t, rs.getInt(fied));
						} else if(type[0] == String.class) {
					//		System.out.println(("NULL").equals(rs.getString(fied)));
							m[i].invoke(t, rs.getString(fied));
						}else if(type[0] == Date.class) {
							m[i].invoke(t, rs.getDate(fied));
						}else if(type[0] == Double.class) {
							m[i].invoke(t, rs.getDouble(fied));
						}
					}
				}
				list.add(t);
				// System.out.println("ok");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeAll(rs, ps, conn);
		}
		return list;
	}
}
