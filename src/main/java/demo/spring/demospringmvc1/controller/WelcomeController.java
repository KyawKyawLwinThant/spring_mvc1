package demo.spring.demospringmvc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class WelcomeController {
  @Autowired
  private ApplicationContext applicationContext;

  @GetMapping("/")
  public String welcome(Model model){
    model.addAttribute("tagline","Hello Spring MVC");
    return "welcome";
  }

  @Bean @Profile("dev")
  public CommandLineRunner runner(){
    return a ->{
      Arrays.stream(this.applicationContext.getBeanDefinitionNames())
              .sorted()
              .forEach(System.out::println);
    };
  }


}
