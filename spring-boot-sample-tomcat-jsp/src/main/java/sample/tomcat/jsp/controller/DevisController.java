package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IDevisService;
import sample.tomcat.jsp.service.IUserService;

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
    private IDevisService devisService;

    @RequestMapping(path = "/devis", method = RequestMethod.GET)
    public ModelAndView userAction(@RequestParam(name = "name",required = true) String nom){
        ModelAndView model = new ModelAndView("devis");

        model.addObject("devis", new Devis());

        return model;
    }

    @RequestMapping(path = "/devis/save", method = RequestMethod.POST)
    public ModelAndView devisActionSave(@ModelAttribute Devis devis){
        ModelAndView model = new ModelAndView("userAfterSave");

        Devis devisSaved = devisService.save(devis);
        System.out.println("user/save -> " + devis.getNom());

        if (devisSaved == null){
            model.setViewName("errorSave");
        }

        return model;
    }

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/dashboard", method = RequestMethod.POST)
    public ModelAndView devisAffiche(@ModelAttribute User user){
        ModelAndView vue = new ModelAndView("dashboard");

        User user2 = userService.findByName("Cencier");
        Devis devisSaved = devisService.findByUser(user2);

        if (devisSaved == null){
            vue.setViewName("403");
        } else {
            vue.addObject("devis", devisSaved);
        }

        return vue;
    }




}
