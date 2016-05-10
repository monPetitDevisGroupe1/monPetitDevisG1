package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape4;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IHabitationEtape4Service {

    HabitationEtape4 save(HabitationEtape4 habitationEtape4);
    HabitationEtape4 findByDevis(Devis devis);
}
