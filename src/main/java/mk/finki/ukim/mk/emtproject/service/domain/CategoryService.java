package mk.finki.ukim.mk.emtproject.service.domain;


import mk.finki.ukim.mk.emtproject.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    Optional<Category> update(Long id, Category category);

    void deleteById(Long id);

    Optional<Category> save(Category category);

}
