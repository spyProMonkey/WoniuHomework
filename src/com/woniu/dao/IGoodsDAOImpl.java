package com.woniu.dao;



import java.util.List;

import com.woniu.bean.Goods;
import com.woniu.util.BaseDAO;


public class IGoodsDAOImpl implements IGoodsDAO {
	BaseDAO<Goods> bd = new BaseDAO<>();
	@Override
	public void delete(int gid) {
		String sql = "delete from goods where gid=? ";
		Object[] objs = {gid};
		bd.update(sql,objs);

	}
	@Override
	public void add(Goods goods) {
		String sql = "insert into goods values (?,?,?) ";
		Object[] objs = {goods.getGid(),goods.getGname(),goods.getPrice()};
		bd.update(sql,objs);
	}


	@Override
	public Goods findOne(int gid) {
		String sql = "select * from goods where gid=? ";
		Object[] objs = {gid};
		List<Goods> list = bd.query(sql,objs,Goods.class);
		return list.size()!=0?list.get(0):null;
	}


	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from goods";
		Object[] objs = {};
		List<Goods> list = bd.query(sql,objs,Goods.class);
		return list;
	}
	@Override
	public void update(Goods goods) {
		// TODO Auto-generated method stub
		String sql = "update goods set gname=? price=? where gid = ?";
		Object[] objs = {goods.getGname(),goods.getPrice(),goods.getGid()};
		bd.update(sql, objs);
	}

}
