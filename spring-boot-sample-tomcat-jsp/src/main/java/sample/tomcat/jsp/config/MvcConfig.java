package sample.tomcat.jsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by S0089075 on 11/02/2016.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/error").setViewName("login");
        registry.addViewController("/private/dashboard").setViewName("dashboard");
        registry.addViewController("/private/profil").setViewName("profil");
        registry.addViewController("/private/profil").setViewName("profil.update");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/private/devis").setViewName("devis");
        registry.addViewController("/voiture").setViewName("voiture-form-1");
        registry.addViewController("/voiture2").setViewName("voiture-form-2");
        registry.addViewController("/voiture3").setViewName("voiture-form-3");
        registry.addViewController("/savev1").setViewName("save-v1");
        registry.addViewController("/private/tab-devis").setViewName("tab-devis");
    }

}
