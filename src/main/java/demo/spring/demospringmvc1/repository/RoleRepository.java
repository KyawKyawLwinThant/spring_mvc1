package demo.spring.demospringmvc1.repository;

import demo.spring.demospringmvc1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

  Role findByName(String name);
}
