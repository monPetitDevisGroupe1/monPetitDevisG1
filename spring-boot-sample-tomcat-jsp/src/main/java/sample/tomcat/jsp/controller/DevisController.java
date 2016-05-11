package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.ApplicationData;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IDevisService;
import sample.tomcat.jsp.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



/**
 * Created by Pierre on 05/04/2016.
 */
@Controller
public class DevisController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUserService userService;

    @Autowired
    ApplicationData session;

    @Autowired
    private IDevisService devisService;

    @Autowired
    private ApplicationData applicationData;

    @RequestMapping(path = "/private/devis.create")
    public ModelAndView userDevis(){

        User user = userService.findById(applicationData.getId());

        String nom = request.getParameter("nom_devis");
        String typeDevis = request.getParameter("type_devis");
        Devis devis = new Devis();
        devis.setNom(nom);
        devis.setTypeDevis(typeDevis);
        devis.setEtape(0);
        devis.setUser(user);
        devisService.save(devis);
        String url;
        if(typeDevis.equals("voiture")){
            url = "/private/wizard";
        }else{
            url = "/private/wizard.habitation";
        }
        ModelAndView model = new ModelAndView("redirect:" + url);

        applicationData.setIdDevis(devis.getIdDevis());
        applicationData.setNomDevis(nom);
        applicationData.setDevis(devis);
        return model;
    }
    @RequestMapping(path = "/private/devis.delete")
    public ModelAndView devisSessionActionDelete() {
        devisService.removeByIdDevis(session.getIdDevis());
        ModelAndView modelReturn = new ModelAndView("dashboard");
        return modelReturn;
    }
    @RequestMapping(path = "/private/devis/save", method = RequestMethod.POST)
    public void devisActionSave(@ModelAttribute Devis devis){
       ModelAndView model = new ModelAndView("userAfterSave");
    }

    @RequestMapping(path = "/private/devis.reprise")
    public ModelAndView repriseDevis() {
        String idDevis = request.getParameter("idDevis");
        int id = Integer.parseInt(idDevis);
        Devis devis = devisService.findByIdDevis(id);

        applicationData.setDevis(devis);
        applicationData.setIdDevis(id);
        applicationData.setNomDevis(devis.getNom());
        String url;
        if(devis.getTypeDevis().equals("voiture")){
            url = "/private/wizard";
        }else{
            url = "/private/wizard.habitation";
        }
        String etapeUrl = "";
        if(devis.getEtape() > 1){
            etapeUrl = "?_page=" + devis.getEtape();
        }
        ModelAndView modelReturn = new ModelAndView("redirect:" + url + etapeUrl);
        return modelReturn;
    }



}
