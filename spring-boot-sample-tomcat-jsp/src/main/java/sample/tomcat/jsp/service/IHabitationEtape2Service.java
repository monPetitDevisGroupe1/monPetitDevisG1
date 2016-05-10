package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape2;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IHabitationEtape2Service {

    HabitationEtape2 save(HabitationEtape2 habitationEtape2);
    HabitationEtape2 findByDevis(Devis devis);
}
