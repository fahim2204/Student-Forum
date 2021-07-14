package luminous.StudentForum.Controller;

import javax.validation.Valid;

import org.springframework.boot.context.properties.bind.BindConstructorProvider;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.RegistrationData;



@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public ModelAndView LoginView(ModelAndView modelAndView){
        modelAndView.addObject("registrationData", new RegistrationData());
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @PostMapping("/registration")
    public String LoginValidation(@Valid @ModelAttribute("registrationData") RegistrationData registrationData, BindingResult result){
       if(result.hasErrors()){
           //System.out.println(loginData);
        return "registration";
        // return "redirect:/registration";
       }
        return "test";
    }
    
}
