package luminous.StudentForum.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("admin")
    public String AdminIndex(){
        return "admin/index";
    }
}
