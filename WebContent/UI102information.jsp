<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sj.bean.*" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報画面</title>
<script type="text/javascript">
<!--

function check(){

	if(window.confirm('退会してよろしいですか？')){ // 確認ダイアログを表示

		return true; // 「OK」時は送信を実行

	}
	else {
		return false;
	}
}

// -->
</script>
</head>
<body>

<h3>会員情報画面</h3>

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
			<input type = "hidden" name="id" value="${member.id}">

		</c:forEach>
			<br>
		<button type="submit" name = "action" value="return">戻る</button>
		<button type="submit" name = "action" value="change">変更</button>
		<button type = "submit" name = "action" value = "unsubscribeMember" onClick="check()">退会</button>
	</form>
		<hr>


<h3>貸出中図書（最大5冊）</h3>
<table border="1">
  <tr><td>資料名</td><td>貸出年月日</td><td>返却期日</td><td>返却</td></tr>
</table>

</body>
</html>