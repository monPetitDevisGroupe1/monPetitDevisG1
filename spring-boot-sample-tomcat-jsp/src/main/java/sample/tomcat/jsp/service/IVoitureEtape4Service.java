package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape4;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IVoitureEtape4Service {

    VoitureEtape4 save(VoitureEtape4 voitureEtape4);
    VoitureEtape4 findByDevis(Devis devis);
}
