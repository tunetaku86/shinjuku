<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
</head>
<body>
	<h2>会員情報</h2><br>

	<form action="/shinjuku/MemberServlet" method="get">
		<c:forEach items="${members}" var="member">
			<h4>会員ID: ${member.id}</h4>
			<h4>名前: ${member.name}</h4>
			<h4>住所: ${member.address}</h4>
			<h4>電話番号: ${member.tel}</h4>
			<h4>メールアドレス: ${member.email}</h4>
			<h4>生年月日: ${member.birthday}</h4>
			<h4>登録日: ${member.admission}</h4>
			<h4>退会日: ${member.unsubscribe}</h4>
			<h4>備考: ${member.remarks}</h4>
		</c:forEach>
			<br>
		<button type="submit" name = "action" value="changeinfo">会員情報の変更</button>
	</form>

	<h3>貸出中の書籍</h3>
	<form action="/shinjuku/" method="get">
		1<br>
		2<br>
		3<br>
		4<br>
		5<br>
	</form>







</body>
</html>