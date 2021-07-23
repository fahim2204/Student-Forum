package luminous.StudentForum.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView LoginView(ModelAndView modelAndView) {
        // modelAndView.addObject("loginData", new LoginData());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/logout")
    public String Logout() {
        return "logout";
    }

    @GetMapping("/logout-success")
    public String LogoutSuccess() {
        return "logout-success";
    }

    // @PostMapping("/login")
    // public String LoginValidation(@Valid @ModelAttribute("loginData") LoginData
    // loginData, BindingResult result){
    // if(result.hasErrors()){
    // //System.out.println(loginData);
    // return "login";
    // }
    // return "test";
    // }
}
