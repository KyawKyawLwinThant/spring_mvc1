package demo.spring.demospringmvc1.controller;


import demo.spring.demospringmvc1.model.Product;
import demo.spring.demospringmvc1.service.CategoryService;
import demo.spring.demospringmvc1.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.naming.Binding;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;

@Controller
public class ProductController {

  private static Logger logger= LoggerFactory.getLogger(ProductController.class);

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
  public String process(@Valid Product product, BindingResult result,Model model){
    if(result.hasErrors()){
      model.addAttribute("categories",categoryService.findAll());
      return "productForm";
    }

    productService.create(product);

    return "redirect:/products";
  }


  @GetMapping("/products")
  public String showAllProducts(Model model){
      model.addAttribute("products",productService.findAll());
      model.addAttribute("register",model.containsAttribute("register"));
      return "products";
  }

  @GetMapping("/products/{id}")
  public String deleteProduct(@PathVariable("id") int id){
    productService.deleteById(id);
    return "redirect:/products";
  }

  @GetMapping("/products/update/{id}")
  public String updateProduct(@PathVariable("id")int id,Model model){
    this.updateProductId=id;
    model.addAttribute("product",productService.findById(id));
    model.addAttribute("categories",categoryService.findAll());
    return "updateForm";
  }

  @PostMapping("/products/update")
  public String updateProcess(Product product){
      productService.updateProduct(product,updateProductId);
      return "redirect:/products";
  }

  @GetMapping("/products/details/{id}")
  public String showDetails(@PathVariable("id") int id,Model model){
    Product product=productService.findById(id);

    logger.info("product is:"+ product);

    model.addAttribute("product",product);
    return "productDetails";
  }
  @GetMapping("/products/pdf")
  public ResponseEntity<InputStreamResource> generatePdf(){
    ByteArrayInputStream bis=PdfReport.productPdfViews(productService.findAll());
    HttpHeaders headers=new HttpHeaders();
    headers.add("Content-Disposition","inline;filename=products_report.pdf");


    return ResponseEntity
            .ok()
            .headers(headers)
            .contentType(MediaType.APPLICATION_PDF)
            .body(new InputStreamResource(bis));
  }

  private int updateProductId;





}
