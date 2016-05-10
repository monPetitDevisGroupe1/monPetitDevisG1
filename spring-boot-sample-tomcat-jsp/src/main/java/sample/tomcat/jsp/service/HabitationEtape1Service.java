package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.HabitationEtape1Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape1;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class HabitationEtape1Service implements IHabitationEtape1Service {


    @Autowired
    private HabitationEtape1Repository habitationRepository;


    @Override
    public HabitationEtape1 save(HabitationEtape1 habitationEtape1){
        return habitationRepository.save(habitationEtape1);
    }

    @Override
    public HabitationEtape1 findByDevis(Devis devis){
        return habitationRepository.findByDevis(devis);
    }

}
