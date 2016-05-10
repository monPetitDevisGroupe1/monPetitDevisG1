package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.HabitationEtape2Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape2;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class HabitationEtape2Service implements IHabitationEtape2Service {


    @Autowired
    private HabitationEtape2Repository habitationRepository;


    @Override
    public HabitationEtape2 save(HabitationEtape2 habitationEtape2){
        return habitationRepository.save(habitationEtape2);
    }

    @Override
    public HabitationEtape2 findByDevis(Devis devis){
        return habitationRepository.findByDevis(devis);
    }

}
