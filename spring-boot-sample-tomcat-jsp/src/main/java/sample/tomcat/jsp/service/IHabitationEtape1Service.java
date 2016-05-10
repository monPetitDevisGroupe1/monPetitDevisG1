package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape1;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IHabitationEtape1Service {

    HabitationEtape1 save(HabitationEtape1 habitationEtape1);
    HabitationEtape1 findByDevis(Devis devis);
}
