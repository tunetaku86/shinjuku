<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
<h3>確認画面</h3>
	<form action="/shinjuku/MemberServlet"name ="method="post">
		名前:${member.name}<br><br>
		住所:${member.address}<br><br>
		電話番号:${member.tel}<br><br>
		E-Mail:${member.email }<br><br>
		生年月日:${member.birth}<br><br>
		<input type="submit" value="登録">
</form>

</body>
</html>