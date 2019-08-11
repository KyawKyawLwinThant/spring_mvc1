package demo.spring.demospringmvc1.controller;

import demo.spring.demospringmvc1.model.Role;
import demo.spring.demospringmvc1.model.User;
import demo.spring.demospringmvc1.repository.RoleRepository;
import demo.spring.demospringmvc1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public DatabaseLoader(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public void run(String... args) throws Exception {
    Role adminRole=new Role("ROLE_ADMIN");
    Role userRole=new Role("ROLE_USER");

    User admin=new User("Thaw","Thaw","adminmail@gmail.com",bCryptPasswordEncoder.encode("thaw"));
    User user=new User("John","William","usermail@gmail.com",bCryptPasswordEncoder.encode("john"));
    //mapping
    admin.addRole(adminRole);
    user.addRole(userRole);

   /* roleRepository.save(userRole);
    roleRepository.save(adminRole);
    userRepository.save(admin);
    userRepository.save(user);*/
  }
}
