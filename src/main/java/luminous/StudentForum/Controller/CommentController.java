package luminous.StudentForum.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import luminous.StudentForum.model.Comment;
import luminous.StudentForum.repository.CategoryRepository;
import luminous.StudentForum.repository.CommentRepository;
import luminous.StudentForum.repository.PostRepository;
import luminous.StudentForum.repository.UserRepository;

@Controller
public class CommentController {

    // ------- For Showing Log --------//
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(RegistrationController.class);


    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CommentRepository commentRepo;
    


    @PostMapping("/comment/create")
    public String CommentCreate(@Valid Comment comment, BindingResult result, HttpServletRequest req){
        // log.info(comment.toString());
        // //log.info(req.getParameter("category"));
        // if(result.hasErrors()){
        //     // model.addAttribute("post", postRepo.getAllPostDetailsByID(req.getParameter("catname"),comment.getFrPost()));
        //     // model.addAttribute("categoryList",catRepo.findAll());
        //     // model.addAttribute("comment",new Comment());
        //     // model.addAttribute("category",catRepo.findAll() );
        //     redirectAttributes.addFlashAttribute("errResult", result);
        //     redirectAttributes.addFlashAttribute("comment", comment);
        //     return "redirect:/posts/Biology/10";
        // }else{
                String redirLink = req.getParameter("returnLink");
                commentRepo.save(comment);
                return "redirect:"+redirLink;
            
    }

    
}
