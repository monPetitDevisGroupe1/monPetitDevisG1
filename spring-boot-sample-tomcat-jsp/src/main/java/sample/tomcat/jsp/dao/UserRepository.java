package sample.tomcat.jsp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sample.tomcat.jsp.entity.User;

import java.util.List;

/**
 * Created by Utilisateur on 07/04/2016.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByNom(String nom);
    User findById(Integer id_user);

    /*
    @Query(value = "select u.nom from User where u.login = :login")
    String findNom(String login);
*/


}
