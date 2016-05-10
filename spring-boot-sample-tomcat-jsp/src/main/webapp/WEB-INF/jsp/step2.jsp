<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Mon Petit Devis : Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<!--<link href="<c:url value='/jsp/static/favicon.ico'/>" rel="shortcut icon"> -->
	</head>
	<body>
	<form:form action="/wizard.form?_page=3" method="post" modelAttribute="modelWizard">
		<form:label path="step2">Step2 : </form:label>
		<form:input path="step2" />
		<input type="submit" value="Go to step 3" />
	</form:form>
	</body>
</html>
