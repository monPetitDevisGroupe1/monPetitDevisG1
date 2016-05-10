package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape4;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface VoitureEtape4Repository extends CrudRepository<VoitureEtape4,Integer> {

    VoitureEtape4 save(VoitureEtape4 voitureEtape4);
    VoitureEtape4 findByDevis(Devis devis);

}
