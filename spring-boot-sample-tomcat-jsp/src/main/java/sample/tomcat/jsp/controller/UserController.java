package sample.tomcat.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sample.tomcat.jsp.entity.User;
import sample.tomcat.jsp.service.IUserService;

/**
 * Created by Utilisateur on 07/04/2016.
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ModelAndView userAction(@RequestParam(name = "name",required = true) String nom){
        ModelAndView model = new ModelAndView("user");

        User user = userService.findByName(nom);
        System.out.println("user -> " + user.getNom());
        model.addObject("user", user);

        return model;
    }

    @RequestMapping(path = "/user/save", method = RequestMethod.POST)
    public ModelAndView userActionSave(@ModelAttribute User user){
        ModelAndView model = new ModelAndView("userAfterSave");

        User userSaved = userService.save(user);
        System.out.println("user/save -> " + user.getNom());

        if (userSaved == null){
            model.setViewName("errorSave");
        }

        return model;
    }

    @RequestMapping(path = "/rest/user/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody User userRestActionSave(@RequestBody User user){
        return user;
    }

}
