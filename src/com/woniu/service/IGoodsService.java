package com.woniu.service;

import java.util.List;

import com.woniu.bean.Goods;

public interface IGoodsService {
	void addGoods (Goods goods);
	void updateGoods (Goods goods);
	void delGoods (int gid);
	Goods findGoods (int gid);
	List<Goods> findAllGoods ();
}
