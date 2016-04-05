<%@ page import="java.sql.*" %><%--
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
    String modele = request.getParameter("modele");
    String marque = request.getParameter("marque");
    String carburant = request.getParameter("carburant");
    String chevaux = request.getParameter("chevaux");


    Connection connexion = null;
    try {
        connexion = DriverManager.getConnection(url, "admin" , "");

        String sql="INSERT INTO user(nom,prenom) VALUES ('"+modele+"', '"+marque+carburant+"')");
        int rs= connexion.executeUpdate(sql);

    } catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
    } finally {
        if ( connexion != null )
            try {
            /* Fermeture de la connexion */
                connexion.close();
            } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
            }
    }

%>

</body>
</html>

