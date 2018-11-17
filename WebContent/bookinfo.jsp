<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>資料情報</title>
</head>

</head>
<body>
	<h2>資料情報</h2><br>

	<form action="/shinjuku/BookServlet" method="get">
		<c:forEach items="${books}" var="book">
			<h4>ISBN: ${book.isbn}</h4>
			<h4>資料名: ${book.name}</h4>
			<h4>カテゴリーコード: ${book.catcode}</h4>
			<h4>作者名: ${book.author}</h4>
			<h4>出版社: ${book.publisher}</h4>
			<h4>登録日: ${book.pubdate}</h4>
		</c:forEach>
			<br>
		<button type="submit" name = "action" value="changeinfo">資料情報の変更</button>
	</form>

	<h3>貸出中の会員</h3>
	<form action="/shinjuku/" method="get">
		1<br>
		2<br>
		3<br>
		4<br>
		5<br>
	</form>


</body>
</html>