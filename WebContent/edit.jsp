<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
  <form action="good.do?method=edit" method="post">
	<c:forEach var="good" items="${goods}" varStatus="i">
     商品序号 <input type="hidden" name="gid"  value="${good.gid}"/><br>
	商品名称<input type="text" name="gname" value="${good.gname}" /><br>
	 
	       商品价格      <input type="text" name="price" value="${good.price}" /><br>
	 <button>提交</button>
	 </c:forEach>
  </form>
</body>
</html>