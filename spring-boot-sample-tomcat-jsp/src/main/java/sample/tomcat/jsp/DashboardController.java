package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by Pierre on 05/04/2016.
 */
@Controller
public class DashboardController {

    @Autowired
    DataSource dataSource;


    @RequestMapping({"/dashboard"})
    public String dashboard(Map<String, Object> model) {
        Statement statement = null;
        ResultSet resultat = null;
        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();

    /* Ici, nous placerons nos requêtes vers la BDD */
    /* ... */

        } catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
        } finally {
            if ( connexion != null )
                try {

                    statement = connexion.createStatement();
                    resultat = statement.executeQuery("SELECT * FROM devis WHERE etape < 4 ORDER BY id_devis DESC LIMIT 1 ");
                    while(resultat.next()){
                        model.put("nom", resultat.getString("nom"));
                        model.put("type_devis", resultat.getString("type_devis"));
                    }
            /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }



        }
        return "dashboard";
    }
}
