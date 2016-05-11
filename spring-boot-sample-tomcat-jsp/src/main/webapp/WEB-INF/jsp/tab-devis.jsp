<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 10/05/2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tableau des devis</title>
</head>
<body>

    <h1>Tableau des devis</h1>


        <c:if test="${not empty listeDevis}">

            <table>
                <tr>
                    <th>Nom</th>
                    <th>Etape</th>
                </tr>
                <c:forEach var="listValue" items="${listeDevis}">
                    <tr>


                        <form action="<c:url value='/private/tab-devis.delete'/>" method="GET">
                            <input style="display:none" type="text" name="idDevis" value="${listValue.getIdDevis()}" />
                            <td name="nom" value="${listValue.getNom()}">${listValue.getNom()}</td>
                            <td name="etape" value="${listValue.getEtape()}">${listValue.getEtape()}</td>
                            <td><button type="submit" value="delete">Supprimer</button></td>
                        </form>
                        <td>
                            <form action="<c:url value='/private/visualisation'/>" method="GET">
                                <button type="submit" name = "idDevis" value="${listValue.getIdDevis()}">Visualiser</button>
                            </form>
                        </td>
                        <td><a href=""> Reprise </a></td>

                    </tr>
                </c:forEach>
            </table>

        </c:if>

       <a href = "<c:url value='/private/dashboard'/>">Retour au dashboard</a>



</body>
</html>
