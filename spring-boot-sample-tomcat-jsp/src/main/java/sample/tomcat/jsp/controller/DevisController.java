package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IUserService;
import java.util.List;



/**
 * Created by Pierre on 05/04/2016.
 */
@Controller
public class DevisController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/private/devis")
    public ModelAndView userDevis(){

        ModelAndView model = new ModelAndView("devis");

        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByNom(username);


        List<Devis> listDevis = user.getDevis();
        String prenom = user.getPrenom();
        System.out.println("TEST PAGE DEVIS :" + listDevis + prenom);

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
