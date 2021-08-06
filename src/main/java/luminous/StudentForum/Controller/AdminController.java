package luminous.StudentForum.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Category;
import luminous.StudentForum.model.Post;
import luminous.StudentForum.model.User;
import luminous.StudentForum.repository.CategoryRepository;
import luminous.StudentForum.repository.PostRepository;
import luminous.StudentForum.repository.UserRepository;

@Controller
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepo;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String AdminIndex() {
        return "admin/index";
    }

    @GetMapping("/admin/category")
    public ModelAndView Category(ModelAndView modelAndView) {
        List<Category> categoryList = categoryRepository.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("category", new Category());
        modelAndView.setViewName("/admin/category");
        return modelAndView;
    }

    @PostMapping("/admin/category")
    public String CategoryCreate(@Valid Category category, BindingResult result, Model model) {
        if (categoryRepository.findByCname(category.getCname()) != null) {
            result.addError(new FieldError("category", "cname", "Category Already exists!!"));
        }
        if (result.hasErrors()) {
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categoryList", categoryList);
            return "/admin/category";
        } else {
            categoryRepository.save(category);
            return "redirect:/admin/category";
        }
    }

    @GetMapping("/admin/category/{cname}/edit")
    public ModelAndView CategoryEdit(@PathVariable("cname") String cname, ModelAndView modelAndView) {
        List<Category> categoryList = categoryRepository.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("cname", cname);
        modelAndView.setViewName("/admin/category-edit");
        return modelAndView;
    }

    @PostMapping("/admin/category/{cname}/edit")
    public String CategoryUpdate(@PathVariable("cname") String cname, @RequestParam("newcname") String newcname) {
        Category category = categoryRepository.findByCname(cname);
        category.setCname(newcname);
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/{cname}/delete")
    public String CategoryDelete(@PathVariable("cname") String cname) {
        categoryRepository.delete(categoryRepository.findByCname(cname));
        return "redirect:/admin/category";
    }

    // # -----------------For User Operation----------------

    @GetMapping("/admin/user")
    public ModelAndView User(ModelAndView modelAndView) {
        List<User> userList = userRepository.findAll();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("/admin/user");
        return modelAndView;
    }

    @GetMapping("/admin/user/change-status/{username}")
    public String ChangeUserStatus(@PathVariable("username") String username) {
        User oldUser = userRepository.findByUsername(username);
        oldUser.setConfirmPassword("confirmPassword");
        if (oldUser.getStatus() == 1) {
            oldUser.setStatus(2);
        } else {
            oldUser.setStatus(1);
        }
        userRepository.save(oldUser);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user")
    public String UserCreate(@Valid Category category, BindingResult result, Model model) {
        if (categoryRepository.findByCname(category.getCname()) != null) {
            result.addError(new FieldError("category", "cname", "Category Already exists!!"));
        }
        if (result.hasErrors()) {
            List<Category> categoryList = categoryRepository.findAll();
            model.addAttribute("categoryList", categoryList);
            return "/admin/category";
        } else {
            categoryRepository.save(category);
            return "redirect:/admin/category";
        }
    }

    @GetMapping("/admin/user/{username}/edit")
    public ModelAndView UserEdit(@PathVariable("username") String username, ModelAndView modelAndView) {
        List<Category> categoryList = categoryRepository.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("cname", username);
        modelAndView.setViewName("/admin/category-edit");
        return modelAndView;
    }

    @PostMapping("/admin/user/{username}/edit")
    public String UserUpdate(@PathVariable("username") String username, @RequestParam("newcname") String newcname) {
        Category category = categoryRepository.findByCname(username);
        category.setCname(newcname);
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/user/{username}/delete")
    public String UserDelete(@PathVariable("username") String username) {
        categoryRepository.delete(categoryRepository.findByCname(username));
        return "redirect:/admin/category";
    }

    // # -----------------For POST Operation----------------

    @GetMapping("/admin/post")
    public ModelAndView Post(ModelAndView modelAndView) {
        modelAndView.addObject("postList", postRepo.getAllPostDetailsNoLimit());
        modelAndView.setViewName("/admin/post");
        return modelAndView;
    }

    @GetMapping("/admin/posts/delete/{id}")
    public String DeletePost(@PathVariable("id") int id) {
        postRepo.delete(postRepo.findById(id));
        return "redirect:/admin/post";
    }

    @GetMapping("/admin/posts/change-status/{id}")
    public String ChangePostStatus(@PathVariable("id") int id) {
        Post oldPost = postRepo.findById(id);
        if (oldPost.getStatus() == 1) {
            oldPost.setStatus(2);
        } else {
            oldPost.setStatus(1);
        }
        postRepo.save(oldPost);
        return "redirect:/admin/post";
    }

}
