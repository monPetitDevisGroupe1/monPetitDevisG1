package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by Pierre on 05/04/2016.
 */
@Controller
public class Voiture1Controller {

    @Autowired
    DataSource dataSource;
    private HttpServletRequest request;
    private Map<String, Object> model;




    //@RequestMapping(path = {"/voiture-1"}, method = RequestMethod.POST)
    @RequestMapping({"/voiture-1"})
    public void voiture1(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws ServletException, IOException {
        this.request = request;

        String marque = request.getParameter("marque");
        String modele = request.getParameter("modele");
        String carburant = request.getParameter("carburant");
        String chevaux = request.getParameter("chevaux");

        System.out.println(marque) ;

        Statement st = null;
        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();

        } catch ( SQLException e ) {
        } finally {
            if ( connexion != null )
                try {
                    st = connexion.createStatement();
                    String query = "INSERT INTO voiture_etape1 (marque, modele, carburant, chevaux_fisc, id_devis) VALUES ('"+marque+"', '"+modele+"', '"+carburant+"', '"+chevaux+"', '"+2+"')" ;
                    System.out.println(query) ;
                    st.executeUpdate(query);

            /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/voiture2");
        rd.forward(request, response);
    }


    //@RequestMapping(path = {"/voiture-1"}, method = RequestMethod.POST)
    @RequestMapping({"/voiture-2"})
    public void voiture2(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws ServletException, IOException {
        this.request = request;

        String marque = request.getParameter("marque");
        String modele = request.getParameter("modele");
        String carburant = request.getParameter("carburant");
        String chevaux = request.getParameter("chevaux");

        System.out.println(marque) ;

        Statement st = null;
        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();

        } catch ( SQLException e ) {
        } finally {
            if ( connexion != null )
                try {
                    st = connexion.createStatement();
                    String query = "INSERT INTO voiture_etape2 (date_permis, nbr_accident, bonus_malus) VALUES ('"+marque+"', '"+modele+"', '"+carburant+"', '"+chevaux+"', '"+2+"')" ;
                    System.out.println(query) ;
                    st.executeUpdate(query);

            /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/voiture3");
        rd.forward(request, response);
    }
}
