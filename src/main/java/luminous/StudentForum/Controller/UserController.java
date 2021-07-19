package luminous.StudentForum.Controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

@Controller
public class UserController {
    
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(RegistrationController.class);


    @GetMapping("/user/{username}")
    @ResponseBody
    public String GetUserProfile(@PathVariable("username") String username){
        return username;
    }
}
