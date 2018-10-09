<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="sj.bean.*" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員管理画面</title>
</head>
<body>


<h1>会員管理画面</h1>
<br>
<form action="/shinjuku/MemberServlet" method="get">

<button type="submit" name = "action" value="return">戻る</button>
<button type = "submit" name="action" value="member_new">新規登録</button>
</form>
<br>
<h2>検索</h2>
<br>

<form action="/shinjuku/MemberServlet" method="get">
ID:<input type="text"name="id">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="id_search">
</form>
<form action="/shinjuku/MemberServlet" method="get">
氏名:<input type="text"name="name"size="30">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="name_search">
</form>
<form action="/shinjuku/MemberServlet" method="get">
TEL:<input type="text"name="tel"size="30">
<input type="submit"  value="検索"><br><br>
<input type="hidden" name="action" value="tel_search">
</form><br><br>
<a href="/shinjuku/MemberServlet?action=findByAll">全件表示</a>
<br>
<br>
<hr>
<h2>検索結果</h2>
<table border="1">
	<tr><th>ID</th><th>氏名</th><th>住所</th><th>TEL</th><th>e-mail</th><th>生年月日</th><th>入会年月日</th><th>退会年月日</th><th>備考</th></tr>
	<c:forEach items="${members}" var="member">
		<tr><td><a href="/shinjuku/MemberServlet?action=information&id=${member.id}">${member.id}</a></td><td>${member.name}</td><td>${member.address}</td><td>${member.tel}</td><td>${member.email}</td><td>${member.birthday}</td><td>${member.admission}</td><td>${member.unsubscribe}</td><td>${member.remarks}</td></tr>
	</c:forEach>
</table>
</body>
</html>