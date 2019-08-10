package demo.spring.demospringmvc1.security;

import demo.spring.demospringmvc1.service.UserDetailsImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebMvcSecurity extends WebSecurityConfigurerAdapter {


  private UserDetailsImpl userDetails;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public WebMvcSecurity(UserDetailsImpl userDetails,BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userDetails = userDetails;
    this.bCryptPasswordEncoder=bCryptPasswordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/static/**","/","products").permitAll()
                .antMatchers("/product").hasRole("ADMIN")
                .antMatchers("/category").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .httpBasic();
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(userDetails)
            .passwordEncoder(bCryptPasswordEncoder);
  }
}
