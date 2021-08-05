package luminous.StudentForum.Controller;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Comment;
import luminous.StudentForum.model.Post;
import luminous.StudentForum.model.User;
import luminous.StudentForum.model.View;
import luminous.StudentForum.repository.CategoryRepository;
import luminous.StudentForum.repository.CommentRepository;
import luminous.StudentForum.repository.PostRepository;
import luminous.StudentForum.repository.UserRepository;
import luminous.StudentForum.repository.ViewRepository;

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
    @Autowired
    private ViewRepository viewRepo;
    @Autowired
    private CommentRepository commentRepo;
    


    @GetMapping("/post/create")
    public ModelAndView CreatePost(ModelAndView modelAndView){
        modelAndView.addObject("category",catRepo.findAll() );
        modelAndView.addObject("post", new Post());
        modelAndView.setViewName("post-create");
        return modelAndView;
    }
    
    @PostMapping("/post/create")
    public String CategoryCreate(@Valid Post post, BindingResult result, HttpSession session, HttpServletRequest req, Model model){
        log.info(req.getParameter("category"));
        if(req.getParameter("category").equals("--Select a Category--")){
            ObjectError error = new ObjectError("catErr","Please Select a Category.");
                result.addError(error);
            // result.addError(new FieldError("category", "category", "Username Already exists!!"));
        }
            if(result.hasErrors()){
                model.addAttribute("category",catRepo.findAll() );
                return "post-create";
            }else{
                catRepo.findByCname(req.getParameter("category")).getPosts().add(post);
                userRepo.findByUsername(session.getAttribute("sessUsername").toString()).getPosts().add(post);
                postRepo.save(post);
                return "redirect:/post/create";
            }

    }


    @GetMapping("/posts/{cat}/{id}")
    public ModelAndView ViewSinglePost(@PathVariable("id") int id, @PathVariable("cat") String cat, ModelAndView modelAndView, HttpSession session, Model model){
        
        if(session.getAttribute("sessUid")!=null){
            int fkuserid = (int)session.getAttribute("sessUid");
            if(viewRepo.findByFkUserAndFkPost(fkuserid, id)==null){
                log.info("view saved");
                viewRepo.save(new View(fkuserid,id));
            }else{
                log.info("view not saved");
            }
        }
        modelAndView.addObject("post", postRepo.getAllPostDetailsByID(cat,id));
        modelAndView.addObject("categoryList",catRepo.findAll());
        modelAndView.addObject("comments",commentRepo.findByFrPostOrderByCreatedAtDesc(id));
        modelAndView.addObject("comment",new Comment());
        modelAndView.setViewName("post-view-single");
        return modelAndView;
    }

    @GetMapping("/posts/page/{page}")
    public ModelAndView ViewAllPost(@PathVariable("page") int page, ModelAndView modelAndView, HttpSession session, Model model){

        Pageable pageable = PageRequest.of(page-1, 5);
        Page<Collection> allPost = postRepo.getAllPostDetailsPagination(pageable);
        String paginationLink = "/posts/page/";
        modelAndView.addObject("postDetails", allPost);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("paginationLink", paginationLink);
        modelAndView.addObject("totalPages", allPost.getTotalPages());
        log.info(postRepo.getAllPostDetailsPagination(pageable));
        log.info(allPost.getTotalPages());
        modelAndView.addObject("categoryList",catRepo.findAll());
        modelAndView.setViewName("all-post");
        return modelAndView;
    }
    @GetMapping("/posts/{cat}/page/{page}")
    public ModelAndView ViewCtegoryPost(@PathVariable("page") int page, @PathVariable("cat") String cat, ModelAndView modelAndView){

        Pageable pageable = PageRequest.of(page-1, 5);
        Page<Collection> allPost = postRepo.getCategoryPostDetailsPagination(cat,pageable);
        String paginationLink = "/posts/"+cat+"/page/";
        modelAndView.addObject("postDetails", allPost);
        modelAndView.addObject("paginationLink", paginationLink);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", allPost.getTotalPages());
        log.info(postRepo.getAllPostDetailsPagination(pageable));
        log.info(allPost.getTotalPages());
        modelAndView.addObject("categoryList",catRepo.findAll());
        modelAndView.setViewName("all-post");
        return modelAndView;
    }
    /// It it will redirect to search using path variable
    @PostMapping("/posts/search")
    public String ViewBySearchPostRediret(HttpServletRequest req){
        String redirecturl = "redirect:/posts/search/"+req.getParameter("search")+"/page/1";
        return redirecturl;
    } 
    @GetMapping("/posts/search/{shrc}/page/{page}")
    public ModelAndView ViewBySearchPost(@PathVariable("page") int page, @PathVariable("shrc") String shrc, ModelAndView modelAndView){

        log.info("hello from search");
        Pageable pageable = PageRequest.of(page-1, 5);
        Page<Collection> allPost = postRepo.getBySearchPostDetailsPagination(shrc,pageable);
        log.info(allPost);
        String paginationLink = "/posts/search/"+shrc+"/page/";
        modelAndView.addObject("postDetails", allPost);
        modelAndView.addObject("paginationLink", paginationLink);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", allPost.getTotalPages());
        log.info(postRepo.getAllPostDetailsPagination(pageable));
        log.info(allPost.getTotalPages());
        modelAndView.addObject("categoryList",catRepo.findAll());
        modelAndView.setViewName("all-post");
        return modelAndView;
    }




}
