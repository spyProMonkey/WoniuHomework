package com.woniu.service;

public class ServiceFactory {
	public static GoodsServiceImpl getGoodsService() {
		return new GoodsServiceImpl();
	}
}
