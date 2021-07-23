package luminous.StudentForum.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping("student")
    public String StudentIndex(){
        return "student/index";
    }
}
