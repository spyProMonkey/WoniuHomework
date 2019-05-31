package com.woniu.dao;


import java.util.List;

import com.woniu.bean.Goods;


public interface IGoodsDAO {
	void add (Goods goods);
	void update (Goods goods);
	void delete (int gid);
	Goods findOne (int gid);
	List<Goods> findAll ();
}
