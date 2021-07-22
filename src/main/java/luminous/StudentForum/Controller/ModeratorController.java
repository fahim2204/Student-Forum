package luminous.StudentForum.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeratorController {
    @GetMapping("moderator")
    public String ModeratorIndex(){
        return "moderator/index";
    }
}
