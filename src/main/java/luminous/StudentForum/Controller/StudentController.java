package luminous.StudentForum.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("student")
    public String StudentIndex(){
        return "student/index";
    }
}
