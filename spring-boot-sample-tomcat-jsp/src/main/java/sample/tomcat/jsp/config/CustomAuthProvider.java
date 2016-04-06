package sample.tomcat.jsp.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.security.AuthProvider;
import java.util.*;

/**
 * Created by Pierre on 05/04/2016.
 */
@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RestTemplate rest = new RestTemplate();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map map = new HashMap();
        map.put("username", username);
        map.put("password", password);

     List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

       String retour =  rest.postForObject("http://localhost:8081/login", map, String.class);
        try{
            JSONObject obj = new JSONObject(retour);
            String statut = obj.getString("statut");
            if(statut.equals("OK")){
                int id_user = obj.getInt("id");
                String token = obj.getString("token");
                authentication = new UsernamePasswordAuthenticationToken(username, password, authorities);

                request.getSession().setAttribute("id_user", id_user);
                request.getSession().setAttribute("token", token);
                System.out.println("Authentification OK !!!");


            }else{
                authentication = null;
                System.out.println("Authentification echouee !!!");
            }

        }catch(JSONException e){
           authentication = null;
        }
        return authentication;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
