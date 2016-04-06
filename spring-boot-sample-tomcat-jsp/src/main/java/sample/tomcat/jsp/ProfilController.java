package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by Pierre on 06/04/2016.
 */
@Controller
public class ProfilController {

    @Autowired
    DataSource dataSource;
    HttpServletRequest request;

    @RequestMapping({"/profil"})
    public String affichageProfil(Map<String, Object> model) {
        Statement statement = null;
        ResultSet resultat;
        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();

        } catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
        } finally {
            if ( connexion != null )
                try {

                    statement = connexion.createStatement();
                    resultat = statement.executeQuery("SELECT * FROM user WHERE id_user = 3");
                    while(resultat.next()){
                        model.put("message", "");
                        model.put("nom", resultat.getString("nom"));
                        model.put("prenom", resultat.getString("prenom"));
                        model.put("date_permis", resultat.getString("date_permis"));
                        }
                    connexion.close();
                } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
        return "profil";
    }

    @RequestMapping({"/profil.update"})
    public String sauvegardeProfil(Map<String, Object> model) {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String message = "";
        model.put("nom", nom);
        model.put("prenom", prenom);

        Statement statement = null;
        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();

        } catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
        } finally {
            if ( connexion != null )
                try {

                    statement = connexion.createStatement();
                    if(statement.executeUpdate("UPDATE user SET nom = '" + nom + "', prenom = '" + prenom + "' WHERE id_user = 3") > 0){
                        message = "Le profil a bien été mis à jour!";
                    }else{
                        message = "Le profil n'a pas pu être mis à jour.";
                    }


                    connexion.close();
                } catch ( SQLException ignore ) {
                    message = "Le profil n'a pas pu être mis à jour (problème d'accès à la BDD).";
                }
        }
        return "profil";
    }

}
