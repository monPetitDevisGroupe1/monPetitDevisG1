package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.VoitureEtape3Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape3;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class VoitureEtape3Service implements IVoitureEtape3Service {


    @Autowired
    private VoitureEtape3Repository voitureRepository;


    @Override
    public VoitureEtape3 save(VoitureEtape3 voitureEtape3){
        return voitureRepository.save(voitureEtape3);
    }

    @Override
    public VoitureEtape3 findByDevis(Devis devis){
        return voitureRepository.findByDevis(devis);
    }

}
