<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>操作成功</h1>
	<c:if test="${user!=null}">
		<p>编号：${user.id}，姓名：${user.name}</p>
		<img alt="头像" src="images/${user.portrait}" title="用户头像" width="400px" height="300px">
	</c:if>
</body>
</html>