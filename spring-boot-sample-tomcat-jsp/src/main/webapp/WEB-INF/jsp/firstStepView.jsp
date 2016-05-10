<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Mon Petit Devis : Login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<!--<link href="<c:url value='/jsp/static/favicon.ico'/>" rel="shortcut icon"> -->
	</head>
	<body>
	<form:form action="/wizard?_page=2" method="post" modelAttribute="modelWizard">
		<form:label path="step1">Step1 : </form:label>

		<input type="submit" value="Go to step 2" />
	</form:form>
	</body>
</html>
