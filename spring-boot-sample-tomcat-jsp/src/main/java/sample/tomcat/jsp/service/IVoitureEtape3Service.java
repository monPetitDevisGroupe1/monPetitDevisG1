package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape3;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IVoitureEtape3Service {

    VoitureEtape3 save(VoitureEtape3 voitureEtape3);
    VoitureEtape3 findByDevis(Devis devis);
}
