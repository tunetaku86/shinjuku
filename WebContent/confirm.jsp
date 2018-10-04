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
<title>入力確認画面</title>
<script type="text/javascript">
<!--

function check(){
	if(window.confirm('登録してよろしいですか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は登録を実行
	}
	else {
		return false;
	}
}

// -->
</script>

</head>
<body>
<h3>入力確認画面</h3><br>
	<form action ="/shinjuku/MemberServlet" method= "get" onSubmit="return check()">
		<input type="hidden" name="action" value="regist2">
		<table border=1>
			<tr><th>氏名</th><td>${member.name}</td></tr>
			<tr><th>住所</th><td>${member.address}</td></tr>
			<tr><th>TEL</th><td>${member.tel}</td></tr>
			<tr><th>Email</th><td>${member.email}</td></tr>
			<tr><th>生年月日</th><td>${member.birthday}</td></tr>
			<tr><th>入会年月日</th><td>${member.admission}</td></tr>
			<tr><th>備考</th><td>${member.remarks}</td></tr>
		</table>
		<hr>
		<input type="submit" value="確認">
	</form>
</body>
</html>
</body>
</html>