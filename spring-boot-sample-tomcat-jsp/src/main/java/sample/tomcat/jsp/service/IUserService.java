package sample.tomcat.jsp.service;

import sample.tomcat.jsp.entity.User;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface IUserService {
    User findByName(String name);

    User save(User user);
}
