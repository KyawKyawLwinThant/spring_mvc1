package demo.spring.demospringmvc1.controller;

import demo.spring.demospringmvc1.model.User;
import demo.spring.demospringmvc1.service.UserDetailsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

  private UserDetailsImpl userDetails;

  public AuthController(UserDetailsImpl userDetails) {
    this.userDetails = userDetails;
  }

  @GetMapping("/login")
  public String login(){
    return "auth/login";
  }

  @GetMapping("/register")
  public String register(Model model){
    model.addAttribute("user",new User());
    return "auth/register";
  }

  @PostMapping("/register")
  public String processRegister(@Valid User user,Model model, RedirectAttributes redirectAttributes, BindingResult result){
    if(result.hasErrors()){
      model.addAttribute("user",user);
      return "auth/register";
    }
    userDetails.register(user);
    redirectAttributes.addFlashAttribute("register",true);
    return "redirect:/products";

  }

}
