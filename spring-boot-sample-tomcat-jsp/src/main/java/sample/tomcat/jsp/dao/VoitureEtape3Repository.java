package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape3;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface VoitureEtape3Repository extends CrudRepository<VoitureEtape3,Integer> {

    VoitureEtape3 save(VoitureEtape3 voitureEtape3);
    VoitureEtape3 findByDevis(Devis devis);

}
