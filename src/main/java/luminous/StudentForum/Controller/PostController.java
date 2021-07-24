package luminous.StudentForum.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Post;
import luminous.StudentForum.repository.CategoryRepository;
import luminous.StudentForum.repository.PostRepository;

@Controller
public class PostController {

    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private PostRepository postRepo;


    @GetMapping("/post/create")
    public ModelAndView CreatePost(ModelAndView modelAndView){
        modelAndView.addObject("category",catRepo.findAll() );
        modelAndView.setViewName("post-create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }
    
    @PostMapping("/post/create")
    public String CategoryCreate(@Valid Post post, BindingResult result){
        // if(category.getCname() != null){
        //     result.addError(new FieldError("category", "cname", "Category Already exists!!"));
        // }
        // if(result.hasErrors()){
        //     return "/admin/category";
        // }else{
            postRepo.save(post);
            return "redirect:/";
        // }
    }
}
