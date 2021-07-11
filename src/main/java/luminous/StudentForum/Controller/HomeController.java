package luminous.StudentForum.Controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Alien;

@Controller
public class HomeController {
    
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
    
        String email = "fahim@gmail.com";
        // modelAndView.addObject("name", name);
        session.setAttribute("age", 15);
        modelAndView.addObject("email", email);
        modelAndView.addObject("date", new Date(System.currentTimeMillis()));
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @RequestMapping("alien")
      public ModelAndView alien(ModelAndView modelAndView, Alien alien ){
    
        modelAndView.addObject("alienObj", alien);
        modelAndView.setViewName("alien");
        return modelAndView;
    }
   
}
