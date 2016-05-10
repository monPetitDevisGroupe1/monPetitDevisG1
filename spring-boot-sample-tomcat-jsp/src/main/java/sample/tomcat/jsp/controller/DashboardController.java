package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.tomcat.jsp.entity.ApplicationData;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IDevisService;
import sample.tomcat.jsp.service.IUserService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Pierre on 05/04/2016.
 */
@Controller
public class DashboardController {

    @Autowired
    IDevisService devisService;
    @Autowired
    IUserService userService;
    @Autowired
    private ApplicationData applicationData;

    @RequestMapping({"/private/dashboard", "/private"})
    public String dashboard(Map<String, Object> model) {

        User user = userService.findById(applicationData.getId());
        List<Devis> listeDevis = devisService.findByUserOrderByIdDevisDesc(user);
        if(listeDevis.size() > 0){
            Devis devis = listeDevis.get(0);
            model.put("nom", devis.getNom());
            model.put("type_devis", devis.getTypeDevis());
            model.put("etape", devis.getEtape());







        }

                      /* while( resultatEtapes.next()){
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
                        } */








        return "dashboard";
    }
}
