package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;

import java.util.List;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface DevisRepository extends CrudRepository<Devis,Integer> {

    Devis save(Devis devis);
    Devis findByIdDevis(int id);
    List<Devis> findByUser(User user);
    List<Devis> findByUserOrderByIdDevisDesc(User user);
    List<Devis> findByUserAndEtape(User user, int etape);
    void delete(Devis devis);

}
