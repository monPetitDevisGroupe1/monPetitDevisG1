<%--
  Created by IntelliJ IDEA.
  User: Pierre
  Date: 11/05/2016
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devis : ${nom}</title>
</head>
<body>
<h1>Visualisation d'un devis</h1>
<h2>${nom}</h2>
<div>
    <table>
    <c:forEach var="listValue" items="${listeValeurs}">
        <tr>
            <th>${listeValue.get(0)} : </th>
            <td>${listeValue.get(0)}</td>
        </tr>
    </c:forEach>
    </table>
</div>



</body>
</html>
