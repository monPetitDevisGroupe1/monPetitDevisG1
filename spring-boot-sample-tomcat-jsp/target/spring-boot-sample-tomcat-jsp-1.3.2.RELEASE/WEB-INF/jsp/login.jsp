<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Spring Security Tutorial - Form</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="<c:url value='/static/favicon.ico'/>" rel="shortcut icon">
		<link href="<c:url value='/static/style.css'/>" rel="stylesheet" type="text/css"/>
	</head>

	<body>
		<H1>Welcome to the Spring Security Form Tutorial!</H1>

		<form id="form" action="<c:url value='/login'/>" method="POST">
			<c:if test="${not empty param.err}">
				<div class="msg-container error">
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
				</div>
			</c:if>
			<c:if test="${not empty param.out}">
				<div class="msg-container logout">
					You've logged out successfully.
				</div>
			</c:if>
			<c:if test="${not empty param.time}">
				<div class="msg-container time">
					You've been logged out due to inactivity.
				</div>
			</c:if>

			Username:<br>
			<input type="text" name="username" value="" class="input-text input-email<c:if test="${not empty param.err}"> input-error</c:if>"/><br><br>
			Password:<br>
			<input type="password" name="password" value="" class="input-text input-pass<c:if test="${not empty param.err}"> input-error</c:if>"/>

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

			<div class="submit-container">
				<input value="connexion" name="submit" type="submit" class="submit-btn"/>
			</div>
		</form>
	</body>
</html>
