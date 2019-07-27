package demo.spring.demospringmvc1.repository;

import demo.spring.demospringmvc1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
         @Query("select p from Product p where p.category.name=:name")
         public List<Product> findProductsByCategoryName(@Param("name") String name);
}
