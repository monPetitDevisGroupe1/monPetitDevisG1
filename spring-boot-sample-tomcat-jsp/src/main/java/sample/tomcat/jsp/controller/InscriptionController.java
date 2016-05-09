package sample.tomcat.jsp.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pierre on 06/04/2016.
 **/
@Controller
public class InscriptionController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    IUserService userService;

    @RequestMapping(path = {"/inscription"}, method = RequestMethod.GET)
    public String dashboard(Map<String, Object> model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Inscription de : " + username);

        Map map = new HashMap();
        map.put("username", username);
        map.put("password", password);

        RestTemplate rest = new RestTemplate();
        String retour =  rest.postForObject("http://localhost:8081/signIn", map, String.class);

        try{
            JSONObject obj = new JSONObject(retour);
            Integer id = Integer.parseInt(obj.getString("id"));

            User newUser = new User();
            newUser.setId(id);
            newUser.setNom(username);
            System.out.println();
            userService.save(newUser);
            System.out.println("L'utilisateur spring a bien été enregistré!");
        }catch(JSONException e){
            System.out.println("Echec de la création de l'user côté spring!");
        }

        return "login";
    }

}
