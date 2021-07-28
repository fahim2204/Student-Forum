package luminous.StudentForum.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import luminous.StudentForum.model.Category;
import luminous.StudentForum.repository.CategoryRepository;

@Controller
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepository;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String AdminIndex(){
        return "admin/index";
    }

    @GetMapping("/admin/category")
    public ModelAndView Category(ModelAndView modelAndView){
        List<Category> categoryList =  categoryRepository.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("category", new Category());
        modelAndView.setViewName("/admin/category");
        return modelAndView;
    }

    @PostMapping("/admin/category")
    public String CategoryCreate(@Valid Category category, BindingResult result){
        if(categoryRepository.findByCname(category.getCname()) != null){
            result.addError(new FieldError("category", "cname", "Category Already exists!!"));
        }
        if(result.hasErrors()){
            return "/admin/category";
        }else{
            categoryRepository.save(category);
            return "redirect:/admin/category";
        }
    }
    @GetMapping("/admin/category/{cname}/edit")
    public ModelAndView CategoryEdit(@PathVariable("cname") String cname, ModelAndView modelAndView){
        List<Category> categoryList =  categoryRepository.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("cname", cname);
        modelAndView.setViewName("/admin/category-edit");
        return modelAndView;
    }
    @PostMapping("/admin/category/{cname}/edit")
    public String CategoryUpdate(@PathVariable("cname") String cname, @RequestParam("newcname") String newcname){
        Category category = categoryRepository.findByCname(cname);
        category.setCname(newcname);
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/category/{cname}/delete")
    public String CategoryDelete(@PathVariable("cname") String cname){
        categoryRepository.delete(categoryRepository.findByCname(cname));
        return "redirect:/admin/category";
    }
}
