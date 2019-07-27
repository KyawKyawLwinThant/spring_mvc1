package demo.spring.demospringmvc1.service;

import demo.spring.demospringmvc1.model.Product;
import demo.spring.demospringmvc1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product create(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product findById(int id) {
    return productRepository.getOne(id);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public void deleteById(int id) {
    productRepository.deleteById(id);

  }
}
