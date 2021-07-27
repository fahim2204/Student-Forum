package luminous.StudentForum.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Category;
import luminous.StudentForum.model.Post;
import luminous.StudentForum.model.User;
import luminous.StudentForum.repository.CategoryRepository;
import luminous.StudentForum.repository.PostRepository;
import luminous.StudentForum.repository.UserRepository;

@Controller
public class PostController {

    // ------- For Showing Log --------//
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(RegistrationController.class);


    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;


    @GetMapping("/post/create")
    public ModelAndView CreatePost(ModelAndView modelAndView){
        modelAndView.addObject("category",catRepo.findAll() );
        modelAndView.setViewName("post-create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }
    
    @PostMapping("/post/create")
    public String CategoryCreate(@Valid Post post, BindingResult result, HttpSession session, HttpServletRequest req){
            //User user = userRepo.findByUsername(session.getAttribute("sessUsername").toString());
            //System.out.println(req.getParameter("category"));
            // Category category = catRepo.findByCname(req.getParameter("category"));

            catRepo.findByCname(req.getParameter("category")).getPosts().add(post);
            userRepo.findByUsername(session.getAttribute("sessUsername").toString()).getPosts().add(post);
            postRepo.save(post);
            return "redirect:/post/create";
        // }
    }
}
