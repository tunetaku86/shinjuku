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
<script type="text/javascript">
<!--

function check(){
	if(window.confirm('変更してよろしいですか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は変更を実行
	}
	else {
		return false;
	}
}

// -->
</script>

<title>会員情報変更</title>
</head>
<body>

<h3>会員情報変更</h3>
<form action ="/shinjuku/MemberServlet" method= "get" onSubmit="return check()">
<c:forEach items="${members}" var="member">
<table border=1>
<tr><th>ID</th><td><input type = "hidden" name="id" value="${member.id}" size="80">${member.id}</td></tr>
<tr><th>名前</th><td><input type = "text" name="name" value="${member.name}" size="80"></td></tr>
<tr><th>住所</th><td><input type = "text" name="address" value="${member.address}" size="80"></td></tr>
<tr><th>TEL</th><td><input type = "text" name="tel" value="${member.tel} "size="80"></td></tr>
<tr><th>Emai</th><td><input type="text" name="email" value="${member.email}" size="80"></td></tr>
<tr><th>生年月日</th><td><input type = "text" name="birthday" value="${member.birthday}" size="80"></td></tr>
<tr><th>入会年月日</th><td><input type = "text" name ="admission" value="${member.admission}" size="80"></td></tr>


<!--	生年月日、入会年月日の変更処理は通常考えられるケースがないため実装しない。
		退会年月日の変更は退会処理にて行うため、会員情報の変更では行わない。

<tr><th>生年月日</th><td><input type = "Date" name ="birthday" value="${member.birthday}" size="80"></td></tr>
<tr><th>入会年月日</th><td><input type = "Date" name ="admission" value="${member.admission}" size="80"></td></tr>
<tr><th>退会年月日</th><td><input type = "Date" name ="unsubscribe" value="${member.unsubscribe}" size="80"></td></tr>

-->

<tr><th>備考：</th><td><input type="text" name="remarks" value="${member.remarks}" size="80"></td></tr>
</table>
<hr>
<input type = "submit" value = "確認">
<input type="hidden" name="action" value="regist_change">
</c:forEach>
</form>
<form action="/shinjuku/MemberServlet" method="get">
<button type="submit" name = "action" value="return">戻る</button>
</form>
</body>
</html>