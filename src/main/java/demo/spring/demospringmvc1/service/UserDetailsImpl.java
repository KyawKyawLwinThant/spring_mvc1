package demo.spring.demospringmvc1.service;

import demo.spring.demospringmvc1.model.Role;
import demo.spring.demospringmvc1.model.User;
import demo.spring.demospringmvc1.repository.RoleRepository;
import demo.spring.demospringmvc1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserDetailsImpl(UserRepository userRepository,RoleRepository roleRepository
  ,BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder=bCryptPasswordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByEmail(email);

    if(!user.isPresent()){
      throw new UsernameNotFoundException(email +" Not Found.");
    }

    return user.get();
  }

  public User register(User user){
    User user1=new User();
    user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user1.setEmail(user.getEmail());
    user1.setFirstName(user.getFirstName());
    user1.setLastName(user.getLastName());
    Role adminRole=roleRepository.findByName("ROLE_ADMIN");
    user1.addRole(adminRole);

    return userRepository.save(user1);

  }
}
