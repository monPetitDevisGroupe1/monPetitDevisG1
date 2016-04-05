<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 04/04/2016
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>

<html>
<head>
    <title> Devis Voiture</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

    <form action="/voiture3">
        <h1>Etape : 3</h1>

        <div>
            <div>
                Conducteur principal :
                <input type="text" name="conduc-princ">
            </div>
            <div>
                Conducteur secondaire :
                <input type="text" name="conduc-sec">
            </div>
            <div>
                Dors dans un garage :
                <input type="checkbox" name="dors-garagge">
            </div>
            <div>
                Adresse :
                <input type="text" name="adresse-garage">
            </div>
        </div>
        <input type="submit" value="Submit" />
    </form>
    <a href="/voiture2">Previous</a>
</body>
</html>
