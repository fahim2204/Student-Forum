package luminous.StudentForum.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.LoginData;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView LoginView(ModelAndView modelAndView){
        modelAndView.addObject("loginData", new LoginData());
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("/login")
    public String LoginValidation(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result){
       if(result.hasErrors()){
        //    System.out.println(result);
        return "login";
       }
        return "test";
    }
}

