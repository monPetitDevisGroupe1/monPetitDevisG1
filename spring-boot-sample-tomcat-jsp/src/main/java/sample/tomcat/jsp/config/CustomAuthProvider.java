package sample.tomcat.jsp.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import java.security.AuthProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pierre on 05/04/2016.
 */
@Component
public class CustomAuthProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RestTemplate rest = new RestTemplate();
        rest.postForObject("http://localhost:8081/login", authentication.getCredentials(), Authentication.class);
        return null;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
