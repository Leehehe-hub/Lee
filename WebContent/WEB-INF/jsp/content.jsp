<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>主页</h1>
	<h2>${content}</h2>
	<c:forEach items="${all}" var="test">
		<p>编号：${test.id}，姓名：${test.name}</p>
	</c:forEach>
	<c:if test="${test!=null}">
		<p>编号：${test.id}，姓名：${test.name}</p>
	</c:if>
</body>
</html>