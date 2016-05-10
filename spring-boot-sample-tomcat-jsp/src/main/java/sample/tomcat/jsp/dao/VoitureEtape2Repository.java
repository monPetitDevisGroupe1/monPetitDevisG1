package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape2;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface VoitureEtape2Repository extends CrudRepository<VoitureEtape2,Integer> {

    VoitureEtape2 save(VoitureEtape2 voitureEtape2);
    VoitureEtape2 findByDevis(Devis devis);

}
