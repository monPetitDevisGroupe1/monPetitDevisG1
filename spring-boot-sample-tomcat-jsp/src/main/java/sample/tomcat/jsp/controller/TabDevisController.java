package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.ApplicationData;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IUserService;

import java.util.List;

/**
 * Created by Utilisateur on 10/05/2016.
 */
public class TabDevisController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ApplicationData applicationData;

    @RequestMapping({"/private/tab-devis"})
    public ModelAndView tabDevis() {

        User user = userService.findById(applicationData.getId());

        ModelAndView model = new ModelAndView("tab-devis");

        model.addObject("listDevis", user.getDevis());

        List<Devis> test = user.getDevis();

        System.out.println("recuperer devis" + test);
        return model;
    }
}
