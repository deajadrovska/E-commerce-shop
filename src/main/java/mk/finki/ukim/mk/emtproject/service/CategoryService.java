package mk.finki.ukim.mk.emtproject.service;


import mk.finki.ukim.mk.emtproject.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Optional<Category> save(Category category);
    Optional<Category> update(Long id, Category category);
    void deleteById(Long id);
}
