<%--
  Created by IntelliJ IDEA.
  User: Pierre
  Date: 11/05/2016
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devis : ${nom}</title>
</head>
<body>
<h1>Visualisation d'un devis</h1>
<p><em>${message}</em></p>
<h2>${nom}</h2>
<div>
    <table>
    <c:forEach var="listValue" items="${listeValeurs}">
        <tr>
            <th>${listValue.get(0)} : </th>
            <td>${listValue.get(1)}</td>
        </tr>
    </c:forEach>
    </table>
</div>

<a href = "<c:url value='/private/dashboard'/>">Retour au dashboard</a>

</body>
</html>
