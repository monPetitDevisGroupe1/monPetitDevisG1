package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.VoitureEtape1Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.VoitureEtape1;



/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class VoitureEtape1Service implements IVoitureEtape1Service {


    @Autowired
    private VoitureEtape1Repository voitureRepository;


    @Override
    public VoitureEtape1 save(VoitureEtape1 voitureEtape1){
        return voitureRepository.save(voitureEtape1);
    }

    @Override
    public VoitureEtape1 findByDevis(Devis devis){
        return voitureRepository.findByDevis(devis);
    }

}
