package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape4;

/**
 * Created by Utilisateur on 07/04/2016.
 */

public interface HabitationEtape4Repository extends CrudRepository< HabitationEtape4,Integer> {

    HabitationEtape4 save(HabitationEtape4 habitationEtape4);
    HabitationEtape4 findByDevis(Devis devis);
}
