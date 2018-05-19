<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>message</h1>
	<h2><font color="red">${ msg }</font></h2>
	<form action="msg" method="post">
		<textarea name="content" rows="5" cols="50"></textarea>
		<input type="submit" value="save">
	</form>
</body>
</html>