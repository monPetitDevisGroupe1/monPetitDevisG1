package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface DevisRepository extends CrudRepository<Devis,Integer> {

    Devis save(Devis devis);
}
