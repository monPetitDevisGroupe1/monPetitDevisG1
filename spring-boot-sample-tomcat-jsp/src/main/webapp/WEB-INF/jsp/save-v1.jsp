<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 05/04/2016
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save etape 1</title>
</head>
<body>

<b>Marque :</b><%= request.getParameter("marque")%><br/>
<b>Modele:</b><%= request.getParameter("modele")%> <br/>

<%
    String test = request.getParameter("modele");

    Connection connection = DriverManager.getConnection(
            "jdbc:odbc:data", "userName", "password");

    Statement statement = connection.createStatement() ;
    ResultSet resultset = statement.executeQuery("select * from Publishers") ;
%>

</body>
</html>

