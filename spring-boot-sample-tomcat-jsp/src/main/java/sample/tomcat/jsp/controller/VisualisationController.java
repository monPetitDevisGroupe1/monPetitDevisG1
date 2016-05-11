package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.*;
import sample.tomcat.jsp.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Pierre on 11/05/2016.
 */
@Controller
public class VisualisationController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private IDevisService devisService;
    @Autowired
    private IVoitureEtape1Service voit1;
    @Autowired
    private IVoitureEtape2Service voit2;
    @Autowired
    private IVoitureEtape3Service voit3;
    @Autowired
    private IVoitureEtape4Service voit4;
    @Autowired
    private IHabitationEtape1Service hab1;
    @Autowired
    private IHabitationEtape2Service hab2;
    @Autowired
    private IHabitationEtape3Service hab3;
    @Autowired
    private IHabitationEtape4Service hab4;

    @RequestMapping({"/private/visualisation"})
    public ModelAndView affichageDevis(){
        String idDevis = request.getParameter("idDevis");
        String validation = request.getParameter("validation");

        Devis devis = devisService.findByIdDevis(Integer.parseInt(idDevis));
        ModelAndView model = new ModelAndView("devis-viewer");
        if(!validation.isEmpty() & validation.equals("1")){
            model.addObject("message", "Votre devis a été correctement enregistré!");
        }else{
            model.addObject("message", "");
        }
        model.addObject("nom", devis.getNom());
        ArrayList<ArrayList<String>> liste = new ArrayList();

        ArrayList<String> type = new ArrayList<>();
        type.add("Type de devis");
        type.add(devis.getTypeDevis());
        liste.add(type);

        if(devis.getEtape()> 0){
            if(devis.getTypeDevis().equals("voiture")){
                VoitureEtape1 v1 = voit1.findByDevis(devis);
                ArrayList<String> marque = new ArrayList<>();
                marque.add("Marque");
                marque.add(v1.getMarque());
                liste.add(marque);
                ArrayList<String> modele = new ArrayList<>();
                modele.add("Modele");
                modele.add(v1.getModele());
                liste.add(modele);
                ArrayList<String> cv = new ArrayList<>();
                cv.add("Chevaux fiscaux");
                cv.add(Integer.toString(v1.getChevauxFisc()));
                liste.add(cv);
                ArrayList<String> carburant = new ArrayList<>();
                carburant.add("Modele");
                carburant.add(v1.getCarburant());
                liste.add(carburant);
                if(devis.getEtape()> 1){
                    VoitureEtape2 v2 = voit2.findByDevis(devis);
                    ArrayList<String> datePermis = new ArrayList<>();
                    datePermis.add("Date du permis");
                    datePermis.add(v2.getDatePermis().toString());
                    liste.add(datePermis);
                    ArrayList<String> nbAcc = new ArrayList<>();
                    nbAcc.add("Nombre d'accidents");
                    nbAcc.add(Integer.toString(v2.getNbrAccident()));
                    liste.add(nbAcc);
                    ArrayList<String> bonus = new ArrayList<>();
                    bonus.add("Date du permis");
                    bonus.add(Integer.toString(v2.getBonusMalus()));
                    liste.add(bonus);
                    if(devis.getEtape()> 2) {
                        VoitureEtape3 v3 = voit3.findByDevis(devis);
                        ArrayList<String> garage = new ArrayList<>();
                        garage.add("Dans un garage");
                        if(v3.getDorsGarage() == 1){
                            garage.add("Oui");
                            ArrayList<String> adresseGarage = new ArrayList<>();
                            adresseGarage.add("Adresse du garage");
                            adresseGarage.add(v3.getAdresseGarage());
                            liste.add(garage);
                            liste.add(adresseGarage);
                        }else{
                            garage.add("Non");
                            liste.add(garage);
                        }
                        ArrayList<String> cond1 = new ArrayList<>();
                        cond1.add("Conducteur principal");
                        cond1.add(v3.getConducteurPrincipal());
                        liste.add(cond1);
                        ArrayList<String> cond2 = new ArrayList<>();
                        cond2.add("Conducteur secondaire");
                        cond2.add(v3.getConducteurSecondaire());
                        liste.add(cond2);
                        if(devis.getEtape()> 3) {
                            VoitureEtape4 v4 = voit4.findByDevis(devis);
                            ArrayList<String> prix = new ArrayList<>();
                            prix.add("Prix");
                            prix.add(Integer.toString(v4.getPrix()));
                            liste.add(prix);
                            ArrayList<String> formule = new ArrayList<>();
                            formule.add("Formule");
                            formule.add(v4.getFormule());
                            liste.add(formule);
                        }
                    }
                }
            }else{
                HabitationEtape1 h1 = hab1.findByDevis(devis);
                ArrayList<String> typeHab = new ArrayList<>();
                typeHab.add("Type habitation");
                typeHab.add(h1.getTypeHabitation());
                liste.add(typeHab);
                ArrayList<String> surface = new ArrayList<>();
                surface.add("Surface");
                surface.add(Integer.toString(h1.getSurface()));
                liste.add(surface);
                if(devis.getEtape()> 1){
                    HabitationEtape2 v2 = hab2.findByDevis(devis);
                    ArrayList<String> nbPieces = new ArrayList<>();
                    nbPieces.add("Nombre de pièces");
                    nbPieces.add(Integer.toString(v2.getNbrPiece()));
                    liste.add(nbPieces);
                    ArrayList<String> nbSdb = new ArrayList<>();
                    nbSdb.add("Nombre de salles de bain");
                    nbSdb.add(Integer.toString(v2.getNbrSalleBain()));
                    liste.add(nbSdb);
                    ArrayList<String> garage = new ArrayList<>();
                    garage.add("Garage");
                    if(v2.getGarage() == 1){
                        garage.add("Oui");
                    }else{
                        garage.add("Oui");
                    }
                    liste.add(garage);
                    if(devis.getEtape()> 2) {
                        HabitationEtape3 h3 = hab3.findByDevis(devis);
                        ArrayList<String> surfaceTerrain = new ArrayList<>();
                        surfaceTerrain.add("Surface du terrain");
                        surfaceTerrain.add(Integer.toString(h3.getSurfaceTerrain()));
                        liste.add(surfaceTerrain);
                        ArrayList<String> surfaceTerasse = new ArrayList<>();
                        surfaceTerasse.add("Surface du terrain");
                        surfaceTerasse.add(Integer.toString(h3.getSurfaceTerrasse()));
                        ArrayList<String> chauffage = new ArrayList<>();
                        chauffage.add("Type de chauffage");
                        chauffage.add(Integer.toString(h3.getTypeChauffage()));
                        liste.add(chauffage);
                        if(devis.getEtape()> 3) {
                            HabitationEtape4 h4 = hab4.findByDevis(devis);
                            ArrayList<String> prix = new ArrayList<>();
                            prix.add("Prix");
                            prix.add(Integer.toString(h4.getPrix()));
                            liste.add(prix);
                            ArrayList<String> formule = new ArrayList<>();
                            formule.add("Formule");
                            formule.add(h4.getFormule());
                            liste.add(formule);
                        }
                    }
                }
            }
        }


        model.addObject("listeValeurs", liste);
        return model;
    }

}
