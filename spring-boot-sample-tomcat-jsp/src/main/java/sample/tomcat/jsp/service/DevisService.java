package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tomcat.jsp.dao.DevisRepository;
import sample.tomcat.jsp.dao.UserRepository;
import sample.tomcat.jsp.entity.Devis;
import sample.tomcat.jsp.entity.User;

import java.util.List;


/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class DevisService implements IDevisService {


    @Autowired
    private DevisRepository devisRepository;


    @Override
    public Devis save(Devis devis){
        return devisRepository.save(devis);
    }

    @Override
    public List<Devis> findByUser(User user){
        return devisRepository.findByUser(user);
    }

    @Override
    public List<Devis> findByUserOrderByIdDevisDesc(User user){
        return devisRepository.findByUserOrderByIdDevisDesc(user);
    }
}
