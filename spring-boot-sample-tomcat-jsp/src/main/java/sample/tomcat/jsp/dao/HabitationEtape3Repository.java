package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape3;

/**
 * Created by Utilisateur on 07/04/2016.
 */

public interface HabitationEtape3Repository extends CrudRepository< HabitationEtape3,Integer> {

    HabitationEtape3 save(HabitationEtape3 habitationEtape3);
    HabitationEtape3 findByDevis(Devis devis);
}
