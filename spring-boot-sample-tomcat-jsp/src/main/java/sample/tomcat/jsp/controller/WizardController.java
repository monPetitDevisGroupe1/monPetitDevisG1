package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.ApplicationData;
import sample.tomcat.jsp.entity.DevisVoiture;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.*;

/**
 * Created by Dylan on 05/04/2016.
 */
@Controller
@RequestMapping("/wizard")
@SessionAttributes("modelWizard")
public class WizardController {

    @Autowired
    IVoitureEtape1Service voiture1;

    @Autowired
    ApplicationData session;

    @Autowired
    IUserService userCourant;

    @Autowired
    IVoitureEtape2Service voiture2;

    @Autowired
    IDevisService devisService;

    @Autowired
    IVoitureEtape3Service voiture3;

    @Autowired
    IVoitureEtape4Service voiture4;

    private String[] pageViews = new String[] {"voiture-form-1","voiture-form-2", "voiture-form-3", "voiture-form-4"};

    @RequestMapping
    public ModelAndView processWizard() {
        ModelAndView modelHabitation = new ModelAndView("voiture-form-1","modelWizard", new DevisVoiture());
        User user = userCourant.findById(session.getId());
        modelHabitation.addObject("user", user);
        modelHabitation.addObject("id_devis", session.getIdDevis());
        modelHabitation.addObject("nom_devis", session.getNomDevis());
        return modelHabitation;
    }

    // Renvois de l'étape suivant le numéro d'étape
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
                                    @ModelAttribute("modelWizard") DevisVoiture modelWizard) {
        // pageViews est un tableau qui renvois le nom de la vue suivant le numéro d'étape
        User user = userCourant.findById(session.getId());

        switch(currentPage) {
            case 2:
                session.getDevis().setEtape(1);
                modelWizard.getVoitureEtape1().setDevis(session.getDevis());
                devisService.save(session.getDevis());
                voiture1.save(modelWizard.getVoitureEtape1());
                break;
            case 3:
                session.getDevis().setEtape(2);
                modelWizard.getVoitureEtape2().setDevis(session.getDevis());
                devisService.save(session.getDevis());
                voiture2.save(modelWizard.getVoitureEtape2());
                break;
            case 4:
                session.getDevis().setEtape(3);
                modelWizard.getVoitureEtape3().setDevis(session.getDevis());
                devisService.save(session.getDevis());
                voiture3.save(modelWizard.getVoitureEtape3());
                break;
        }
        ModelAndView modelHabitation = new ModelAndView(pageViews[currentPage-1],"modelWizard",modelWizard);
        modelHabitation.addObject("id_devis", session.getIdDevis());
        modelHabitation.addObject("nom_devis", session.getNomDevis());
        modelHabitation.addObject("user", user);
        return modelHabitation;
    }
    /**
     * Dernière page
     */
    @RequestMapping(params = "_finish")
    public ModelAndView processFinish(@ModelAttribute("modelWizard") DevisVoiture modelWizard, SessionStatus status) {
        session.getDevis().setEtape(4);
        modelWizard.getVoitureEtape4().setDevis(session.getDevis());

        voiture4.save(modelWizard.getVoitureEtape4());
        // suppression de l'objet en session
        status.setComplete();
        return new ModelAndView("successView");
    }

    @RequestMapping(params = "_cancel")
    public String processCancel(SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return "canceledView";
    }
}
