package sample.tomcat.jsp.service;

import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface IDevisService {

    Devis save(Devis user);
    Devis findByUser(User user);
}
