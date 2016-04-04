package sample.tomcat.jsp.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sample.tomcat.jsp.config.SecurityCOnfig;
import sample.tomcat.jsp.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S0089075 on 11/02/2016.
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals(SecurityCOnfig.USER_NAME)){
            User u = new User();
            u.setUserName(SecurityCOnfig.USER_NAME);
            u.setPassword(SecurityCOnfig.PASSWORD);

            return u;
        } else if (username.equals(SecurityCOnfig.USER_NAME_ADMIN)){
            User u = new User();
            u.setUserName(SecurityCOnfig.USER_NAME_ADMIN);
            u.setPassword(SecurityCOnfig.PASSWORD);
            List<GrantedAuthority> l = new ArrayList<GrantedAuthority>();
            l.add(new SimpleGrantedAuthority("ROLE_YEAH"));
            u.setAuthorities(l);
            return u;
        }
        throw new UsernameNotFoundException("Username not found");
    }
}
