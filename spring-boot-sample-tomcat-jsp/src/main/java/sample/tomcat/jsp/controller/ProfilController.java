package sample.tomcat.jsp.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IUserService;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Pierre on 06/04/2016.
 */
@Controller
public class ProfilController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUserService userService;

    @RequestMapping({"/private/profil"})
    public ModelAndView affichageProfil(){

        String username = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByNom(username);
       //User user = userService.findById(30);

        ModelAndView model = new ModelAndView("profil");
        model.addObject("nom", user.getNom());
        model.addObject("prenom", user.getPrenom());
        model.addObject("date_permis", user.getDatePermis());

        RestTemplate rest = new RestTemplate();
        Map map = new HashMap();

        map.put("id", user.getId());
        map.put("update", false);

        System.out.println("On se connecte à VertX!");
        String retour =  rest.postForObject("http://localhost:8081/profil", map, String.class);

        System.out.println(retour);
        try{
            JSONObject obj = new JSONObject(retour);
            String pseudo = obj.getString("pseudo");
            model.addObject("username", pseudo);

        }catch(JSONException e) {
            System.out.println(e);
        }

        System.out.println("Modele trouve");
        return model;
    }

    @RequestMapping({"/private/profil.update"})
    public ModelAndView sauvegardeProfil(Map<String, Object> model){

        System.out.println("On va récupérer l'user : ");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sDate  = request.getParameter("datepermis");
        String newUsername = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("sDate : " + sDate);
        ModelAndView modelRetour = new ModelAndView("profil");
        modelRetour.addObject("nom", nom);
        modelRetour.addObject("prenom", prenom);
        modelRetour.addObject("username", newUsername);


        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        System.out.println("On va récupérer l'user : ");
        String username = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(username);
        User user = userService.findByNom(username);
        System.out.println("User trouvé !");
        user.setNom(nom);
        user.setPrenom(prenom);
        try{
            Date datePermis = format.parse(sDate);
            System.out.println("datePermis : " + datePermis);
            java.sql.Date sqlDate = new java.sql.Date(datePermis.getTime());
            System.out.println("sqlDate : " + sqlDate);
            modelRetour.addObject("date_permis", sqlDate);
            user.setDatePermis(sqlDate);
        }catch(java.text.ParseException e){

        }

        RestTemplate rest = new RestTemplate();

        if(!(newUsername.isEmpty() | newUsername.equals("")) | (password.isEmpty() | password.equals(""))){
            Map map = new HashMap();
            map.put("id", user.getId());
            map.put("username", newUsername);
            map.put("password", password);
            map.put("update", true);

            String retour =  rest.postForObject("http://localhost:8081/profil", map, String.class);
            System.out.println(retour);
        }


        userService.save(user);
        System.out.println("User sauvegardé!");
        return(modelRetour);
    }

}
