<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 04/04/2016
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>

<html>
<head>
    <title> Devis Voiture</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="<c:url value='/static/favicon.ico'/>" rel="shortcut icon">
    <link href="<c:url value='/static/style.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>

    <c:url value="/voiture" var="url"/>
    <spring:url value="/voiture" htmlEscape="true"/>
    <form>
        <h1>Etape : 1</h1>
        <label> Nom : </label>
        <label> Prénom : </label>

        <label> Nom du devis : </label>
        Marque :
        <input type="text" name="marque">

        Model :
        <input type="text" name="modele">

        Carburant :
        <input type="text" name="carburant">

        Chevaux fiscaux :
        <input type="text" name="chevaux">

    </form>
</body>
</html>
