package demo.spring.demospringmvc1.service;

import demo.spring.demospringmvc1.model.User;
import demo.spring.demospringmvc1.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService {

  private UserRepository userRepository;

  public UserDetailsImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByEmail(email);

    if(!user.isPresent()){
      throw new UsernameNotFoundException(email +" Not Found.");
    }

    return user.get();
  }
}
