package luminous.StudentForum.Controller;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.InitBinder;


import luminous.StudentForum.model.UserData;



@Controller
public class RegistrationController {

//  ------- For Showing Log --------//
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(RegistrationController.class);
    
//  ------- For filtering unwanted space and character --------//
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
    	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
   

    @GetMapping("/registration")
    public ModelAndView LoginView(ModelAndView modelAndView){
        //modelAndView.addObject("registrationData", new RegistrationData());
        modelAndView.addObject("userData", new UserData());
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @PostMapping("/registration")
    public String LoginValidation(@Valid UserData userData, BindingResult result){
    	log.info(userData.toString());
       if(result.hasErrors()){
           //System.out.println(loginData);
        return "registration";
        // return "redirect:/registration";
       }
        return "test";
    }
    
}
