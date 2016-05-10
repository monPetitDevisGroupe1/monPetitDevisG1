package sample.tomcat.jsp.controller;

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


    @RequestMapping({"/private/dashboard", "/private"})
    public String dashboard(Map<String, Object> model) {
        Statement statement = null;
        ResultSet resultat0,  resultatEtapes;
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
                    resultat0 = statement.executeQuery("SELECT * FROM devis ORDER BY id_devis DESC LIMIT 1 ");


                    while(resultat0.next()){
                        model.put("nom", resultat0.getString("nom"));
                        String typeDevis = resultat0.getString("type_devis");
                        model.put("type_devis",typeDevis );
                        model.put("etape", resultat0.getInt("etape"));
                        String table = typeDevis.toLowerCase() + "_etape";
                        int id_devis = resultat0.getInt("id_devis");
                        String query = "SELECT * FROM " + table + "1 t1 " +
                                "LEFT JOIN " + table + "2 t2 ON t1.id_devis = t2.id_devis " +
                                "LEFT JOIN " + table + "3 t3 ON t1.id_devis = t3.id_devis " +
                                "LEFT JOIN " + table + "4 t4 ON t1.id_devis = t4.id_devis " +
                                " WHERE t1.id_devis = " + id_devis;

                        //System.out.println(query);
                        resultatEtapes = statement.executeQuery(query);

                        while( resultatEtapes.next()){
                            model.put("carburant",  resultatEtapes.getString("carburant"));
                            model.put("marque",  resultatEtapes.getString("marque"));
                            model.put("modele",  resultatEtapes.getString("modele"));
                            model.put("chevaux_fisc",  resultatEtapes.getString("chevaux_fisc"));
                            model.put("date_permis",  resultatEtapes.getString("date_permis"));
                            model.put("nbr_accident",  resultatEtapes.getString("nbr_accident"));
                            model.put("bonus_malus",  resultatEtapes.getString("bonus_malus"));
                            model.put("dors_garage",  resultatEtapes.getString("dors_garage"));
                            model.put("adresse_garage",  resultatEtapes.getString("adresse_garage"));
                            model.put("conducteur_principal",  resultatEtapes.getString("conducteur_principal"));
                            model.put("conducteur_secondaire",  resultatEtapes.getString("conducteur_secondaire"));
                            model.put("prix",  resultatEtapes.getString("prix"));
                            model.put("formule",  resultatEtapes.getString("formule"));
                        }
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
