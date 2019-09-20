<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String basePath=request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
</head>
<body>
	<h1>测试页</h1>
	<button class="test btn-primary">测试JQuery</button>
	<button onclick="test()" class="btn-info">测试JavaScript</button>
	<hr/>
	<p><a href="content">跳转到主页</a></p>
	<hr/>
	<p><a href="showAll">查询全部数据</a></p>
	<hr/>
	<form action="show" method="post">
		输入要查询的id：<input type="number" name="id" required/>
		<input type="submit" value="查询" />
	</form>
	<hr/>
	<form action="delete" method="post">
		输入要删除的姓名：<input type="text" name="name" required/>
		<input type="submit" value="删除" />
	</form>
	<hr/>
	<form action="update" method="post">
		输入待更新姓名的id：<input type="number" name="id" required/>
		输入准备更新的姓名：<input type="text" name="name" required/>
		<input type="submit" value="更新" />
	</form>
	<hr/>
	<form action="insert" method="post">
		输入要新增的姓名：<input type="text" name="name" required/>
		<input type="submit" value="新增" />
	</form>
	<hr/>
	带头像的注册
	<form action="upload" method="post" enctype="multipart/form-data">
		姓名：<input type="text" name="name"/>
		头像：<input type="file" name="portrait">
		<input type="submit" value="注册"/>
	</form>
	<hr/>
	<form action="login" method="post">
		姓名：<input type="text" name="name"/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>
