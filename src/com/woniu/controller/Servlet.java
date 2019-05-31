package com.woniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Goods;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/goods.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method =request.getParameter("method");
		if (method==null||method.equals("findAll")) {
			findAll(request,response);
		}else if (method.equals("add")) {
			add(request,response);
		}else if (method.equals("del")) {
			del(request,response);
		}else if (method.equals("edit")) {
			edit(request,response);
		}else if (method.equals("findOne")) {
			findOne(request,response);
		}
	}

	private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer gid=Integer.parseInt(request.getParameter("gid"));
		Goods goods=ServiceFactory.getGoodsService().findGoods(gid);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer gid=Integer.parseInt(request.getParameter("gid"));
		String gname=request.getParameter("gname");
		double price=Double.parseDouble(request.getParameter("price"));
		Goods goods=new Goods(gid, gname, price);
		ServiceFactory.getGoodsService().updateGoods(goods);
		response.sendRedirect("good.do?method=findAll");
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Goods> goods=ServiceFactory.getGoodsService().findAllGoods();
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("index.jsp").forward(request, response);;
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer gid=Integer.parseInt(request.getParameter("gid"));
		ServiceFactory.getGoodsService().delGoods(gid);
		response.sendRedirect("good.do?method=findAll");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer gid=Integer.parseInt(request.getParameter("gid"));
		String gname=request.getParameter("gname");
		double price=Double.parseDouble(request.getParameter("price"));
		Goods goods=new Goods(gid, gname, price);
		ServiceFactory.getGoodsService().addGoods(goods);
		response.sendRedirect("goods.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
