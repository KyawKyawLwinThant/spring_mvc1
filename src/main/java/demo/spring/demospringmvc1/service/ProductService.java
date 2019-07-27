package demo.spring.demospringmvc1.service;

import demo.spring.demospringmvc1.model.Product;

import java.util.List;

public interface ProductService {

  Product create(Product product);

  Product findById(int id);

  List<Product> findAll();

  void deleteById(int id);
}
