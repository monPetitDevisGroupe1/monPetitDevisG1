package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.VoitureEtape2Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape2;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class VoitureEtape2Service implements IVoitureEtape2Service {


    @Autowired
    private VoitureEtape2Repository voitureRepository;


    @Override
    public VoitureEtape2 save(VoitureEtape2 voitureEtape2){
        return voitureRepository.save(voitureEtape2);
    }

    @Override
    public VoitureEtape2 findByDevis(Devis devis){
        return voitureRepository.findByDevis(devis);
    }

}
