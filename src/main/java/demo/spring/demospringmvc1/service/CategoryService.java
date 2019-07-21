package demo.spring.demospringmvc1.service;

import demo.spring.demospringmvc1.model.Category;

import java.util.List;

public interface CategoryService {

  Category create(Category category);

  Category findById(int id);

  List<Category> findAll();


}
