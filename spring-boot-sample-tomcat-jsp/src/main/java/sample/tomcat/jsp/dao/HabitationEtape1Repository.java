package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity. HabitationEtape1;
import sample.tomcat.jsp.entity.VoitureEtape1;

/**
 * Created by Utilisateur on 07/04/2016.
 */

public interface HabitationEtape1Repository extends CrudRepository< HabitationEtape1,Integer> {

    HabitationEtape1 save(HabitationEtape1 habitationEtape1);
    HabitationEtape1 findByDevis(Devis devis);
}
