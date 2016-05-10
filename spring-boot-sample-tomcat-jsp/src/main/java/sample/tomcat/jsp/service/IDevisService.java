package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;

import java.util.List;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IDevisService {

    Devis save(Devis user);
    List<Devis> findByUser(User user);
    List<Devis> findByUserOrderByIdDevisDesc(User user);
    List<Devis> findByUserAndEtape(User user, int etape);
    void remove(Devis devis);
}
