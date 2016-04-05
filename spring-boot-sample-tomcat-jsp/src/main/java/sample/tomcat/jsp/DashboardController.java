package sample.tomcat.jsp;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by Pierre on 05/04/2016.
 */
public class DashboardController {

    @RequestMapping({"/","/index"})
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        return "welcome";
    }
}
