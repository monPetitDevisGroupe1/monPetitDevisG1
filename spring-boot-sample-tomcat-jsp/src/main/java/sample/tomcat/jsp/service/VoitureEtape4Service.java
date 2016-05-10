package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.VoitureEtape4Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape4;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class VoitureEtape4Service implements IVoitureEtape4Service {


    @Autowired
    private VoitureEtape4Repository voitureRepository;


    @Override
    public VoitureEtape4 save(VoitureEtape4 voitureEtape4){
        return voitureRepository.save(voitureEtape4);
    }

    @Override
    public VoitureEtape4 findByDevis(Devis devis){
        return voitureRepository.findByDevis(devis);
    }

}
