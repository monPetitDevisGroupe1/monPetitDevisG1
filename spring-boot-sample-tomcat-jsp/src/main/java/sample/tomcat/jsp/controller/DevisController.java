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
        devis.setEtape(1);
        devis.setUser(user);
        devisService.save(devis);
        String url;
        if(typeDevis.equals("voiture")){
            url = "/wizard";
        }else{
            url = "/wizard.habitation";
        }
        ModelAndView model = new ModelAndView("redirect:" + url);

        applicationData.setIdDevis(devis.getIdDevis());
        applicationData.setNomDevis(nom);
        return model;
    }

    @RequestMapping(path = "/private/devis/save", method = RequestMethod.POST)
    public void devisActionSave(@ModelAttribute Devis devis){
       ModelAndView model = new ModelAndView("userAfterSave");
    }
/*
        //Devis devisSaved = devisService.save(devis);
        System.out.println("user/save -> " + devis.getNom());
        if (devisSaved == null){
            model.setViewName("errorSave");
        }
        return model;*/

/*

    @Autowired
    private IUserService userService;
/*
    @RequestMapping(path = "/dashboard", method = RequestMethod.POST)
    public ModelAndView devisAffiche(@ModelAttribute User user){
        ModelAndView vue = new ModelAndView("dashboard");
        User user2 = userService.findByNom("Cencier");
        List<Devis> devisSaved = devisService.findByUser(user2);

        if (devisSaved == null){
            vue.setViewName("403");
        } else {
            vue.addObject("devis", devisSaved);
        }

        return vue;
    */




}
