package com.woniu.service;

import java.util.List;

import com.woniu.bean.Goods;
import com.woniu.dao.DAOFactory;

public class GoodsServiceImpl implements IGoodsService {

	@Override
	public void addGoods(Goods goods) {
		DAOFactory.getGoodsDAO().add(goods);
	}

	@Override
	public void updateGoods(Goods goods) {
		DAOFactory.getGoodsDAO().update(goods);
	}

	@Override
	public void delGoods(int gid) {
		// TODO Auto-generated method stub
		DAOFactory.getGoodsDAO().delete(gid);
	}

	@Override
	public Goods findGoods(int gid) {
		// TODO Auto-generated method stub
		
		return DAOFactory.getGoodsDAO().findOne(gid);
	}

	@Override
	public List<Goods> findAllGoods() {
		// TODO Auto-generated method stub
		return DAOFactory.getGoodsDAO().findAll();
	}

	
	
}
