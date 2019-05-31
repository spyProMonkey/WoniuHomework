package com.woniu.dao;

public class DAOFactory {
	public static IGoodsDAO getGoodsDAO() {
		return new IGoodsDAOImpl();
	}
}
