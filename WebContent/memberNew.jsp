<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>会員登録</title>
</head>
<body>
	<h3>新規会員登録</h3>
	<form action="/shinjuku/MemberServlet" method="post">
		名前:<input type="text" name="name"><br><br>
		住所:<input type="text" name="address"><br><br>
		電話番号:<input type="text" name="tel"><br><br>
		E-Mail:<input type="text" name="email"><br><br>
		生年月日:<input type="text" name="birth"><br><br>
		<input type="submit" value="確認">
	</form>

</body>
</html>