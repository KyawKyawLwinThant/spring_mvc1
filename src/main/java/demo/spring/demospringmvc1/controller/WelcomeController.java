package demo.spring.demospringmvc1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static Logger logger= LoggerFactory.getLogger(WelcomeController.class);

  @Autowired
  private ApplicationContext applicationContext;

  @GetMapping("/home")
  public String welcome(Model model){
    model.addAttribute("tagline","Hello Spring MVC");

    return "welcome";
  }

  @Bean @Profile("dev")
  public CommandLineRunner runner(){
    return a ->{
      logger.error("Simple Logger Message.");
      Arrays.stream(this.applicationContext.getBeanDefinitionNames())
              .sorted()
              .forEach(System.out::println);
    };

  }


}
