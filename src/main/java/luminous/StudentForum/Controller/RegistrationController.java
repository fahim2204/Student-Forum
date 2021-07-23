package luminous.StudentForum.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import luminous.StudentForum.repository.UserRepository;
// import luminous.StudentForum.service.UserService;
import luminous.StudentForum.service.UserService;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.InitBinder;

import luminous.StudentForum.model.User;

@Controller
public class RegistrationController {

    // ------- For Showing Log --------//
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(RegistrationController.class);

    // ------- For filtering unwanted space and character --------//
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepo;


    @GetMapping("/registration")
    public ModelAndView LoginView(ModelAndView modelAndView) {
        // modelAndView.addObject("registrationData", new RegistrationData());
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public String LoginValidation(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        //-----Check if username already exists
        if(user.getUsername() != null && userService.userExists(user.getUsername())){
            result.addError(new FieldError("user", "username", "Username Already exists!!"));
        }
        //-----Checking for confirm password matches 
        if((user.getPassword()!=null && user.getConfirmPassword()!=null)){
            if(!user.getPassword().equals(user.getConfirmPassword())){
                result.addError(new FieldError("user", "confirmPassword", "Confirm Password isn't match!!"));
            }
        }
        log.info(user.toString());
        // log.info("++++++++++++=======+++++++++");
        if (result.hasErrors()) {
            return "registration";
        }else{
            userService.save(user);
            redirectAttributes.addFlashAttribute("message","Registration is Succesfull.");
            return "redirect:/login";
        }
    }

}
