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
</head>
<body>

    <form action="/voiture3">
        <h1>Etape : 2</h1>
        <div>
            <div>
                Date du permis :
                <input type="date" name="permis">
            </div>
            <div>
                Nombre d’accident :
                <input type="number" name="nbr-accident">
            </div>
            <div>
                Bonus malus :
                <input type="number" name="bonus-malus">
            </div>
        </div>
        <input type="submit" value="Submit" />
    </form>
    <a href="/voiture">Previous</a>
</body>
</html>
