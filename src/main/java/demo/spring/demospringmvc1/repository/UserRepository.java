package demo.spring.demospringmvc1.repository;

import demo.spring.demospringmvc1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

  Optional<User> findByEmail(String email);
}
