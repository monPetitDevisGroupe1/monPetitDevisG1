package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.ApplicationData;
import sample.tomcat.jsp.entity.DevisHabitation;
import sample.tomcat.jsp.entity.DevisVoiture;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.*;

/**
 * Created by Dylan on 05/04/2016.
 */
@Controller
@RequestMapping("/wizard.habitation")
@SessionAttributes("modelWizard")
public class WizardControllerHabitation {

    @Autowired
    ApplicationData session;

    @Autowired
    IUserService userCourant;

    @Autowired
    IHabitationEtape1Service habitation1;

    @Autowired
    IHabitationEtape2Service habitation2;

    @Autowired
    IDevisService devisService;

    @Autowired
    IHabitationEtape3Service habitation3;

    @Autowired
    IHabitationEtape4Service habitation4;

    private String[] pageViews = new String[] {"habitation-form-1","habitation-form-2", "habitation-form-3", "habitation-form-4"};

    @RequestMapping
    public ModelAndView processWizard() {
        ModelAndView modelHabitation = new  ModelAndView("habitation-form-1","modelWizard", new DevisHabitation());
        User user = userCourant.findById(session.getId());
        modelHabitation.addObject("user", user);
        modelHabitation.addObject("id_devis", session.getIdDevis());
        modelHabitation.addObject("nom_devis", session.getNomDevis());
        return modelHabitation;
    }

    // Renvois de l'étape suivant le numéro d'étape
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
                                    @ModelAttribute("modelWizard") DevisHabitation modelWizard) {
        // pageViews est un tableau qui renvois le nom de la vue suivant le numéro d'étape
       switch(currentPage) {
            case 2:
                session.getDevis().setEtape(1);
                modelWizard.getHabitationEtape1().setDevis(session.getDevis());
                devisService.save(session.getDevis());
                habitation1.save(modelWizard.getHabitationEtape1());
                break;
            case 3:
                session.getDevis().setEtape(2);
                modelWizard.getHabitationEtape2().setDevis(session.getDevis());
                devisService.save(session.getDevis());
                habitation2.save(modelWizard.getHabitationEtape2());
                break;
            case 4:
                session.getDevis().setEtape(3);
                modelWizard.getHabitationEtape3().setDevis(session.getDevis());
                devisService.save(session.getDevis());
                habitation3.save(modelWizard.getHabitationEtape3());
                break;
        }
        User user = userCourant.findById(session.getId());
        ModelAndView modelHabitation = new ModelAndView(pageViews[currentPage-1],"modelWizard",modelWizard);
        modelHabitation.addObject("user", user);
        return modelHabitation;
    }
    /**
     * Dernière page
     */
    @RequestMapping(params = "_finish")
    public ModelAndView processFinish(@ModelAttribute("modelWizard") DevisHabitation modelWizard, SessionStatus status) {
        session.getDevis().setEtape(4);
        modelWizard.getHabitationEtape4().setDevis(session.getDevis());
        devisService.save(session.getDevis());
        habitation4.save(modelWizard.getHabitationEtape4());
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
