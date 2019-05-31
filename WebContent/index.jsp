<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
</head>
<body>
	<table border="1" width="800" align="center">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>编辑</th>
			<th>删除</th>

		</tr>
		<c:forEach var="g" items="${goods}" varStatus="i">
			<tr>
				<th>${g.gid}</th>
				<th>${g.gname}</th>
				<th>${g.price}</th>
				<th><a href="goods.do?method=findOne&gid=${g.gid}">编辑 </a></th>
				<th><a href="goods.do?method=del&gid=${g.gid}">删除</a></th>
			</tr>
		</c:forEach>

		<tr>
			<th colspan="5"><a href="goods.do?method=add">添加</a></th>
		</tr>
		<tr>
			<td colspan="5"><a href="goods.do?pageNum=1">首页</a> <a
				href="goods.do?pageNum=${pb.getPageNum()==1?1:pb.getPageNum()-1 }">上一页</a>
				<a
				href="goods.do?pageNum=${pb.getPageNum()==pb.getCountPage()?pb.getCountPage():pb.getPageNum()+1 }">下一页</a>
				<a href="goods.do?pageNum=${pb.getCountPage()}">末页</a></td>
		</tr>
	</table>
	<form action="goods.do?method=add" method="post" align="center"
		width="800">
		商品序号 <input type="text" name="gid" value="${good.gid}" /> 商品名称<input
			type="text" name="gname" value="${good.gname}" /> 商品价格 <input
			type="text" name="price" value="${good.price}" />
		<button>提交</button>
	</form>
</body>
</html>