package sample.tomcat.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

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



        return "login";
    }

}
