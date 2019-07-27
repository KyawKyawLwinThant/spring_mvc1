package demo.spring.demospringmvc1.controller;


import demo.spring.demospringmvc1.model.Product;
import demo.spring.demospringmvc1.service.CategoryService;
import demo.spring.demospringmvc1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class ProductController {

  @Autowired
  private ProductService productService;
  @Autowired
  private CategoryService categoryService;


  @GetMapping("/product")
  public String create(Model model){
    model.addAttribute("product",new Product());
    model.addAttribute("categories",categoryService.findAll());
    return "productForm";
  }


  @PostMapping("/product")
  public String process(@Valid Product product, BindingResult result){
    if(result.hasErrors()){
      return "productForm";
    }

    productService.create(product);

    return "redirect:/products";
  }


  @GetMapping("/products")
  public String showAllProducts(Model model){
      model.addAttribute("products",productService.findAll());
      return "products";
  }
  @GetMapping("/products/{id}")
  public String deleteProduct(@PathVariable("id") int id){
    productService.deleteById(id);
    return "redirect:/products";
  }



}
