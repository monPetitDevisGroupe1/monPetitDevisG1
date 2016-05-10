package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.HabitationEtape4Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape4;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class HabitationEtape4Service implements IHabitationEtape4Service {


    @Autowired
    private HabitationEtape4Repository habitationRepository;


    @Override
    public HabitationEtape4 save(HabitationEtape4 habitationEtape4){
        return habitationRepository.save(habitationEtape4);
    }

    @Override
    public HabitationEtape4 findByDevis(Devis devis){
        return habitationRepository.findByDevis(devis);
    }

}
