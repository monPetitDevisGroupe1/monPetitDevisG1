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
</head>

<body>

    <form action="savev1" methode="GET">
        <h1>Etape : 1</h1>
        <label> Nom : </label>
        <label> Prénom : </label><br/>

        <label> Nom du devis : </label><br/>
        <div>
            <div>
                Marque :
                <input type="text" name="marque">
            </div>
            <div>
                Model :
                <input type="text" name="modele">
            </div>
            <div>
                Carburant :
                <input type="text" name="carburant">
            </div>
            <div>
                Chevaux fiscaux :
                <input type="text" name="chevaux">
            </div>
        </div>
        <input type="submit" value="Submit" />
    </form>



</body>
</html>
