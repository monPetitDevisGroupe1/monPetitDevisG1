package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Pierre on 05/04/2016.
 */
public class DashboardController {

    @Autowired
    DataSource dataSource;


    @RequestMapping({"/","/index"})
    public String welcome(Map<String, Object> model) {


/* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/bdd_sdzee";

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
            /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }

        model.put("time", new Date());
        return "welcome";
    }
}
