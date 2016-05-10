package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.HabitationEtape3Repository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape3;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class HabitationEtape3Service implements IHabitationEtape3Service {


    @Autowired
    private HabitationEtape3Repository habitationRepository;


    @Override
    public HabitationEtape3 save(HabitationEtape3 habitationEtape3){
        return habitationRepository.save(habitationEtape3);
    }

    @Override
    public HabitationEtape3 findByDevis(Devis devis){
        return habitationRepository.findByDevis(devis);
    }

}
