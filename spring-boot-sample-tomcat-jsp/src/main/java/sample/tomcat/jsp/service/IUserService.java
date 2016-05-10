package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.User;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IUserService {
    User findByNom(String name);
    User findById(Integer id);
    User save(User user);
}
