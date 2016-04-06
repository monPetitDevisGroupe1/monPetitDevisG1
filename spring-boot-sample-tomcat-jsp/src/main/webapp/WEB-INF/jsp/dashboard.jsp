<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Mon petit devis</h1>
<h2>Dashboard</h2>

<c:if test="${true}">
    <h3>Devis en cours : </h3>
    Nom : ${nom} <br />
    Type : ${type_devis} <br />
</c:if>
</body>
</html>
