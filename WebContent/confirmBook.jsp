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
	<form action ="/shinjuku/BookServlet" method= "get" onSubmit="return check()">
		<input type="hidden" name="action" value="regist2">
		<table border=1>
			<tr><th>ISBN</th><td>${book.isbn}</td></tr>
			<tr><th>資料名</th><td>${book.name}</td></tr>
			<tr><th>カテゴリーコード</th><td>${book.catcode}</td></tr>
			<tr><th>作者名</th><td>${book.author}</td></tr>
			<tr><th>出版社</th><td>${book.publisher}</td></tr>
			<tr><th>出版日</th><td>${book.pubdate}</td></tr>
			<tr><th>画像URL</th><td>${book.coverurl}</td></tr>
		</table>
		<hr>
		<input type="submit" value="確認">
	</form>
</body>
</html>
</body>
</html>