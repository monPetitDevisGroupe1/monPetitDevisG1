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
		Step 1 : ${modelWizard.step1} <br/>
		Step 2 : ${modelWizard.step2} <br/>
		Step 3 : ${modelWizard.step3} <br/>
	</body>
</html>
