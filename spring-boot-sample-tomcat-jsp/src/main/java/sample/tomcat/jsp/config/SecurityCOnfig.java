package sample.tomcat.jsp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import sample.tomcat.jsp.service.CustomUserDetailService;

/**
 * Created by S0089075 on 11/02/2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true) //prePostEnabled = true
public class SecurityCOnfig extends WebSecurityConfigurerAdapter {

    public static String USER_NAME = "toto";
    public static String USER_NAME_ADMIN = "admin";
    public static String PASSWORD = new BCryptPasswordEncoder().encode("toto");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure -> http");

        //http.csrf().disable();
        http.authorizeRequests().antMatchers("/","index", "/fail", "fail2").permitAll()
                //.antMatchers("/private/admin/**").hasRole("ADMIN")
                .antMatchers("/private/**").fullyAuthenticated()
                .and()
                    .formLogin()
                    .loginPage( "/login" )
                    .loginProcessingUrl( "/login.do" )
                    .defaultSuccessUrl( "/" )
                    .failureUrl( "/login?err=1" )
                    .usernameParameter( "username" )
                    .passwordParameter( "password" )
                .and()
                    .exceptionHandling()
                    .accessDeniedPage( "/403" )
                .and()
                // This is where the logout page and process is configured. The logout-url is the URL to send
                // the user to in order to logout, the logout-success-url is where they are taken if the logout
                // is successful, and the delete-cookies and invalidate-session make sure that we clean up after logout
                .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
                .logoutSuccessUrl( "/login?out=1" )
                .deleteCookies( "JSESSIONID" )
                .invalidateHttpSession( true )
                .and()

                // The session management is used to ensure the user only has one session. This isn't
                // compulsory but can add some extra security to your application.
                .sessionManagement()
                .invalidSessionUrl( "/login?time=1" )
                .maximumSessions( 1 );
    }


/*
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("configure -> auth");

        auth.authenticationProvider(this.customAuthProvider);

        auth.userDetailsService(userDetailsService()).passwordEncoder(new ShaPasswordEncoder());

    }
    */

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception
    {
        System.out.println("configure -> auth");

        //auth.authenticationProvider(this.customAuthProvider);

        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());

    }

}
