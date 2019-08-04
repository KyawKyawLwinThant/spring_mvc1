package demo.spring.demospringmvc1.aspect;

import demo.spring.demospringmvc1.model.Product;
import demo.spring.demospringmvc1.service.ProductService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@Aspect
@Component
public class ProductAspect {
    @Autowired
    private ProductService productService;

    private static Logger logger= LoggerFactory.getLogger(ProductAspect.class);


    @Before("execution(* demo.spring.demospringmvc1.controller.*.*(..))")
    public void loggingAspect(JoinPoint joinPoint){
      System.out.println("Logging Aspect");
          logger.info(joinPoint.getSignature().getName() +" invoked."+ LocalDateTime.now());
      Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* *.showDetails(..))")
    public void checkProductAspect(JoinPoint joinPoint){

      Object[] object=joinPoint.getArgs();
      Integer id=(Integer)object[0];
      logger.info("Check Product:"+ id);
      Product product=productService.findById(id);
      logger.info("Product:"+ product);
      if(product==null){
        throw new EntityNotFoundException(id + " Not Found.");

      }
    }
}
