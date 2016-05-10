package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape2;

/**
 * Created by Utilisateur on 07/04/2016.
 */

public interface HabitationEtape2Repository extends CrudRepository< HabitationEtape2,Integer> {

    HabitationEtape2 save(HabitationEtape2 habitationEtape2);
    HabitationEtape2 findByDevis(Devis devis);
}
