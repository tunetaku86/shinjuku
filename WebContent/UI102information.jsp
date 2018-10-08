<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sj.bean.*" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更画面</title>
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

<h3>会員情報変更画面</h3>

ID:${member.id}<br><br>
氏名:${member.name }<br><br>
住所:${member.address}<br><br>
電話番号:${member.tel }<br><br>
Email:${member.email }<br><br>
生年月日:${member.birthday }<br><br>
入会年月日:${member.admission }<br><br>
退会年月日:${member.unsubscribe }<br><br>
備考:${member.remarks}<br><br>

<hr>

<h3>貸出中図書（最大5冊）</h3>
<table border="1">
  <tr><td>資料名</td><td>貸出年月日</td><td>返却期日</td></tr>
</table>

<hr>
<form method="get" action="/shinjuku/MemberServlet">
<button type = "submit" value = "return" >戻る</button>

<button type = "submit" value = "change">変更</button>

<button type = "submit" value = "Unsubscribe" onClick="check()">退会</button>

</form>

</body>
</html>