<%@page import="ru.job4j.forum.service.PostService"%>
<%@page import="ru.job4j.forum.model.Post"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<form action="<c:url value='/post/save'/>" method='POST'>
	<input type="hidden" name='id' value="${post.id}">
		<table>
			<tr>
				<td>Название:</td>
				<td><input type='text' name='name' value="${post.name}"></td>
			</tr>
			<tr>
				<td>Текст:</td>
				<td><input type='text' name='desc' value="${post.desc}"></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Сохранить" /></td>
			</tr>
		</table>
	</form>
</body>
</html>