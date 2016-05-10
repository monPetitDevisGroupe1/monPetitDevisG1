package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape1;

import java.util.List;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IVoitureEtape1Service {

    VoitureEtape1 save(VoitureEtape1 voitureEtape1);
    VoitureEtape1 findByDevis(Devis devis);
}
