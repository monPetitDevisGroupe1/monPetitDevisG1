package sample.tomcat.jsp.service;

import org.springframework.stereotype.Component;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.HabitationEtape3;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Component
public interface IHabitationEtape3Service {

    HabitationEtape3 save(HabitationEtape3 habitationEtape3);
    HabitationEtape3 findByDevis(Devis devis);
}
