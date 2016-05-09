package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IUserService;

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
/*
    @Autowired
    private IUserService userService;

    @RequestMapping({"/private/profil"})
    public ModelAndView affichageProfil(){
            Integer id =

            ModelAndView model = new ModelAndView("profil");

            User user = userService.findById(id);
            System.out.println("user -> " + user.getNom());
            model.addObject("user", user);

            return model;
        return null;
        }*/
/*
    @RequestMapping({"/private/profil.update"})
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
*/
}
