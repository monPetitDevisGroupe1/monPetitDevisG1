package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.entity.VoitureEtape1;

import java.util.List;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface VoitureEtape1Repository extends CrudRepository<VoitureEtape1,Integer> {

    VoitureEtape1 save(VoitureEtape1 voitureEtape1);
    VoitureEtape1 findByDevis(Devis devis);

}
