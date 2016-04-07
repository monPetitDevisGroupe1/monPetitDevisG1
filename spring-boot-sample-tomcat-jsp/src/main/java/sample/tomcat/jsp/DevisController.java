package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
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
public class DevisController {

    @Autowired
    DataSource dataSource;
    private HttpServletRequest request;
    private Map<String, Object> model;


    @RequestMapping({"/devisValidate"})
    public void devis(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws ServletException, IOException {
        this.request = request;
        this.model = model;

        String nom = request.getParameter("nom_devis");
        String type = request.getParameter("type_devis");

        Statement st = null;
        int id_devis = 0 ;
        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();


    /* Ici, nous placerons nos requêtes vers la BDD */
    /* ... */

        } catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
        } finally {
            if ( connexion != null ) {
                try {

                    st = connexion.createStatement();
                    String query = "INSERT INTO devis (id_user, nom, type_devis, etape) VALUES ('" + 3 + "', '" + nom + "', '" + type + "', '" + 0 + "')";

                    System.out.println(query);
                    st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                    ResultSet rSetIdGenerees = st.getGeneratedKeys();
                    while (rSetIdGenerees.next()) {
                        id_devis = rSetIdGenerees.getInt(1);
                    }

            /* Fermeture de la connexion */
                    connexion.close();
                } catch (SQLException ignore) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
            }
        }


        System.out.println(type);

        if(type.equals("voiture")) {
            RequestDispatcher rd = request.getRequestDispatcher("/voiture");
            request.setAttribute("id_devis", id_devis);
            System.out.println(request.getParameterValues("id_devis"));
            rd.forward(request, response);

        }else if(type.equals("habitation")) {
            RequestDispatcher rd = request.getRequestDispatcher("/habitation");
            request.setAttribute("id_devis", id_devis);

            rd.forward(request, response);
        }
    }


}
