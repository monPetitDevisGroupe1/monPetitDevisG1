package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.DevisVoiture;
import sample.tomcat.jsp.entity.ModelWizard;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IDevisService;
import sample.tomcat.jsp.service.IUserService;

/**
 * Created by Dylan on 05/04/2016.
 */
@Controller
@RequestMapping("/wizard")
@SessionAttributes("modelWizard")
public class WizardController {

    private String[] pageViews = new String[] {"voiture-form-1","voiture-form-2", "voiture-form-3", "voiture-form-4"};

    @RequestMapping
    public ModelAndView processWizard() {
        return new ModelAndView("voiture-form-1","modelWizard", new DevisVoiture());
    }

    // Renvois de l'étape suivant le numéro d'étape
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
                                    @ModelAttribute("modelWizard") DevisVoiture modelWizard) {
        // pageViews est un tableau qui renvois le nom de la vue suivant le numéro d'étape
        return new ModelAndView(pageViews[currentPage-1],"modelWizard",modelWizard);
    }
    /**
     * Dernière page
     */
    @RequestMapping(params = "_finish")
    public ModelAndView processFinish(@ModelAttribute("modelWizard") DevisVoiture modelWizard, SessionStatus status) {
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
