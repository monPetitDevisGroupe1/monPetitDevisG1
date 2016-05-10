package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape2;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IVoitureEtape2Service {

    VoitureEtape2 save(VoitureEtape2 voitureEtape2);
    VoitureEtape2 findByDevis(Devis devis);
}
