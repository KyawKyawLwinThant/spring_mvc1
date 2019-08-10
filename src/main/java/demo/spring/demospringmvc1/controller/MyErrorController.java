package demo.spring.demospringmvc1.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

  @GetMapping("/error")
  public String handleError(Model model, HttpServletRequest request){
    Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if(statusCode!=null){
      switch (Integer.valueOf(statusCode.toString())){
       case 404:
         model.addAttribute("msg","Your Page Not Found.");
         model.addAttribute("url",request.getRequestURL());
         break;
        case 500:
          model.addAttribute("msg","Internal Server Error.");
          model.addAttribute("url",request.getRequestURL());

          break;

        case 403:
          model.addAttribute("msg","You are forbidden.");
          model.addAttribute("url",request.getRequestURL());

        break;
      }

    }


    return "error";
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
