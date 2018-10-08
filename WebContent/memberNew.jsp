<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="sj.bean.*" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録画面</title>
</head>
<body>
<h3>新規登録画面</h3><br>
<form action ="/shinjuku/MemberServlet" method= "get">
<table border=1>
<tr><th>氏名</th><td><input type ="text" name = "name" size="80"></td></tr>
<tr><th>住所</th><td><input type ="text" name = "address" size="80"></td></tr>
<tr><th>TEL</th><td><input type ="text" name = "tel" size="80"></td></tr>
<tr><th>Email</th><td><input type ="text" name = "email"  size="80"></td></tr>
<tr><th>生年月日</th><td><input type ="Date" name = "birthday" size="80"></td></tr>
<tr><th>入会年月日</th><td><input type ="Date" name = "admission" size="80"></td></tr>

<tr><th>備考</th><td><input type ="text" name = "remarks" size="80"></td></tr>
		</table>
		<hr>
		<button type="submit" name = "action" value="return">戻る</button>
		<input type="submit"value="確認">
		<input type="hidden" name="action" value="regist">
	</form>
</body>
</html>