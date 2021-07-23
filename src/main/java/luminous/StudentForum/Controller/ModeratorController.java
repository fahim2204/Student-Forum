package luminous.StudentForum.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeratorController {
    @PreAuthorize("hasAnyRole('MODERATOR')")
    @GetMapping("moderator")
    public String ModeratorIndex(){
        return "moderator/index";
    }
}
