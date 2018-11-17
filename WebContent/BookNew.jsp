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
<title>資料登録画面</title>
</head>
<body>
<h3>資料登録画面</h3><br>
<form action ="/shinjuku/BookServlet" method= "get">
<table border=1>
<tr><th>isbn</th><td><input type ="text" name = "isbn" size="80"></td></tr>
<tr><th>資料名</th><td><input type ="text" name = "name" size="80"></td></tr>
<tr><th>カテゴリーコード</th><td><input type ="text" name = "catcode" size="80"></td></tr>
<tr><th>作者名</th><td><input type ="text" name = "author"  size="80"></td></tr>
<tr><th>出版社</th><td><input type ="text" name = "publisher" size="80"></td></tr>
<tr><th>出版日</th><td><input type ="Date" name = "pubdate" size="80"></td></tr>
<tr><th>画像URL</th><td><input type ="text" name = "coverurl" size="80"></td></tr>
		</table>
		<hr>
		<button type="submit" name = "action" value="return">戻る</button>
		<input type="submit"value="確認">
		<input type="hidden" name="action" value="regist">
	</form>
</body>
</html>