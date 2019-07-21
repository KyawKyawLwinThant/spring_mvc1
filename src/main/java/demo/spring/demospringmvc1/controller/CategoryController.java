package demo.spring.demospringmvc1.controller;

import demo.spring.demospringmvc1.model.Category;
import demo.spring.demospringmvc1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String create(Model model){
      model.addAttribute("category",new Category());

      return "categoryForm";
    }

    @PostMapping("/category")
    public String process(@Valid Category category, BindingResult result){
      if(result.hasErrors()){
        return "categoryForm";
      }
      categoryService.create(category);

      return "redirect:/categories";

    }

    @GetMapping("/categories")
    public String showAllCategory(Model model){
      model.addAttribute("categories",categoryService.findAll());
      return "categories";
    }

}
