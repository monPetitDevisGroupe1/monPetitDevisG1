package sample.tomcat.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.BooleanComparator;
import sample.tomcat.jsp.dao.UserRepository;
import sample.tomcat.jsp.entity.User;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name){
        return userRepository.findByNom(name);
    }

    @Override
    public User findById(Integer id) { return userRepository.findById(id);}

    @Override
    public User save(User user){
        return userRepository.save(user);
    }


}
