<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 10/05/2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tableau des devis</title>
</head>
<body>

    <h1>Tableau des devis</h1>


    <form id="form" action="<c:url value='/private/tab-devis.update'/>" method="GET">

        <p>test : ${tab-devis}</p>


       <a href = "<c:url value='/private/dashboard'/>">Annuler</a>
    </form>

</body>
</html>
