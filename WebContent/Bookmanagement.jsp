<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="sj.bean.*" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>



<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>資料管理画面</title>
</head>
<body>


<h1>資料管理画面</h1>

<br>
<form action="/shinjuku/BookServlet" method="get">

<a href="/shinjuku/BookServlet?action=top_return">トップメニューに戻る</a><br><br>
<button type = "submit" name="action" value="book_new">新規資料登録</button>
</form>
<br>
<h2>検索</h2>
<br>

<form action="/shinjuku/BookServlet" method="get">
ISBN:<input type="text"name="isbn">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="isbn_search">
</form>

<form action="/shinjuku/BookServlet" method="get">
資料名:<input type="text"name="name"size="30">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="name_search">
</form>

<form action="/shinjuku/BookServlet" method="get">
作者:<input type="text"name="author"size="30">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="author_search">
</form><br><br>

<form action="/shinjuku/BookServlet" method="get">
出版社:<input type="text"name="publisher"size="30">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="publisher_search">
</form><br><br>

<a href="/shinjuku/BookServlet?action=findByAll">全件表示</a>
<br>
<br>
<hr>
<h2>検索結果</h2>
<table border="1">
	<tr><th>ISBN</th><th>書籍名</th><th>カテゴリーCD</th><th>作者名</th><th>出版社</th><th>登録日</th><th>画像URL</th></tr>
	<c:forEach items="${books}" var="book">
		<tr><td><a href="/shinjuku/BookServlet?action=information&isbn=${book.isbn}">${book.isbn}</a></td><td>${book.name}</td><td>${book.catcode}</td><td>${book.author}</td><td>${book.publisher}</td><td>${book.pubdate}</td><td>${book.coverurl}</td></tr>
	</c:forEach>
</table>
</body>
</html>



