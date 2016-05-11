package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.ApplicationData;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IDevisService;
import sample.tomcat.jsp.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by Utilisateur on 10/05/2016.
 */
@Controller
public class TabDevisController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDevisService devisService;

    @Autowired
    private ApplicationData applicationData;

    @RequestMapping({"/private/tab-devis"})
    public ModelAndView tabDevis() {

        User user = userService.findById(applicationData.getId());

        ModelAndView model = new ModelAndView("tab-devis");

        List<Devis> listeDevis = devisService.findByUser(user);
        List<Devis> listeDevisFinis = devisService.findByUserAndEtape(user, 4);

        System.out.println("test" + listeDevis);
        model.addObject("listeDevis", listeDevis);


        for (int i=0; i<listeDevis.size() ; i++){

            int nom = listeDevis.get(i).getIdDevis();
            model.addObject("nom", nom);
            System.out.println("test2" +nom);
        }

        return model;
    }

    @RequestMapping({"/private/tab-devis.delete"})
    public ModelAndView deleteDevis(Map<String, Object> model){

        User user = userService.findById(applicationData.getId());
        String idDevis = request.getParameter("idDevis");

        System.out.println("entre dans le delete" + idDevis);
        devisService.removeByIdDevis(Integer.parseInt(idDevis));



        ModelAndView modelReturn = new ModelAndView("redirect:/private/tab-devis");

        return modelReturn;

    }
}
