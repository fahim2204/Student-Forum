package luminous.StudentForum.Controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Post;
import luminous.StudentForum.repository.CategoryRepository;
import luminous.StudentForum.repository.PostRepository;



@Controller
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepo;
    
    /*@RequestMapping("/")
    // public String hello(HttpServletRequest req, Model model){
    // public String hello(String name, HttpSession session, Model model,HttpServletRequest request){
    public String hello(@RequestParam("myname") String name, HttpSession session, Model model,HttpServletRequest request){
        // String name = req.getParameter("name");
        String email = "fahim@gmail.com";

        //////-------Print from session-------////////
        // HttpSession session = req.getSession();
        // req.setAttribute("name", name);
        request.setAttribute("name", name);

        //////-------Print to view using request object-------////////
        session.setAttribute("age", 15);
        ///////////------Send to view using model------/////////// 
        model.addAttribute("email", email);
        model.addAttribute("date", new Date(System.currentTimeMillis()));
        return "home";
    }*/

    // @RequestMapping("/**")
    // public String notFound() {
    //     return "errors/404";
    // }


    @RequestMapping("/")
      public ModelAndView hello(HttpSession session,HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.addObject("categoryList",categoryRepository.findAll());
        modelAndView.addObject("postList",postRepo.findAll());
        modelAndView.addObject("postCol",postRepo.getAllPostDetails());
        // System.out.println(postRepo.getAllPostDetails());

        modelAndView.setViewName("home");
        return modelAndView;
    }

   
}
