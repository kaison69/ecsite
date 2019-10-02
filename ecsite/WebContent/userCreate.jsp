<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>UserCreate画面</title>

</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
	</div>
	<s:if test="errorMessage" !=''">
		<s:property value="errorMessage" escape="false" />
	</s:if>
	<table>
		<s:form action="UserCreateConfirmAction">
			<tr>
				<td><label>ﾛｸﾞｲﾝID:</label></td>
				<td><input type="text" name="loginUserId" value="" /></td>
			</tr>
			<tr>
				<td><label>ﾛｸﾞｲﾝPASS:</label></td>
				<td><input type="text" name="loginPassword" value="" /></td>
			</tr>
			<tr>
				<td><label>ﾕｰｻﾞｰ名:</label></td>
				<td><input type="text" name="userName" value="" /></td>
			</tr>
			<s:submit value="登録" />
		</s:form>
	</table>
	<div>
		<span>前画面に戻る場合は</span> <a href='<s:url action="HomeAction" />'>こちら</a>
	</div>

	<div id="footer"></div>
</body>
</html>
