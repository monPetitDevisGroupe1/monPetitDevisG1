package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.service.IDevisService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 11/05/2016.
 */
@Controller
public class VisualisationController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IDevisService devisService;


    @RequestMapping({"/private/visualisation"})
    public ModelAndView affichageDevis(){
        String idDevis = request.getParameter("idDevis");
        Devis devis = devisService.findByIdDevis(Integer.parseInt(idDevis));
        ModelAndView model = new ModelAndView("devis-viewer");
        model.addObject("nom", devis.getNom());
        ArrayList<ArrayList<String>> liste = new ArrayList();
        ArrayList<String> test = new ArrayList<>();
        test.add("Nomtest");
        test.add("ValeurTest");
        liste.add(test);
        model.addObject("listeValeurs", liste);
        return model;
    }

}
