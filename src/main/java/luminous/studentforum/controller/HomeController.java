package luminous.studentforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
        public String LoadHomePage(){
            return "home";
        }
    @GetMapping("/login")
        public String LoadLoginPage(){
            return "login";
        }
    @GetMapping("/registration")
        public String LoadRegisterPage(){
            return "registration";
        }
    @GetMapping("/error")
        public String LoadErrorPage(){
            return "error";
        }
}
