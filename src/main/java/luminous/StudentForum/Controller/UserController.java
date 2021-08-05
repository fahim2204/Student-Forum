package luminous.StudentForum.Controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;
import luminous.StudentForum.model.User;
import luminous.StudentForum.repository.PostRepository;
import luminous.StudentForum.repository.UserRepository;
import luminous.StudentForum.service.UserService;

@Controller
public class UserController {
    
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(UserController.class);
    @Autowired //! Don't Miss that...
    private UserRepository userRepo;
    @Autowired 
    private PostRepository postRepo;


    @GetMapping("/user/{username}")
    public ModelAndView UserProfile(@PathVariable("username") String username, ModelAndView modelAndView){
        modelAndView.addObject("user", userRepo.findByUsername(username));
        modelAndView.addObject("userPost", postRepo.getUserPostDetails(username));
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
