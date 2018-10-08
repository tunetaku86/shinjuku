<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>新宿図書管理システム</title>
</head>
<body>
	<h1>新宿図書館　管理システム</h1>
	<a href="/shinjuku/MemberServlet?action=return">トップメニューに戻る</a>
	<br>
	<h3>会員管理</h3>
	<a href="/shinjuku/MemberServlet?action=serch">検索</a>
	<a href="/shinjuku/MemberServlet?action=member_new">登録</a>
	<br>
	<h3>資料管理</h3>
	<a href="/shinjuku/BookServlet?action=serch">検索</a>
	<a href="/shinjuku/BookServlet?action=regist">登録</a>

	<a href="/shinjuku/BookServlet?action=lend">貸出</a>
	<a href="/shinjuku/BookServlet?action=return">返却</a>

</body>
</html>