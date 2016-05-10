package sample.tomcat.jsp.dao;

import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.User;


/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User save(User user);
    User findByNom(String nom);
    User findById(Integer id);

}
