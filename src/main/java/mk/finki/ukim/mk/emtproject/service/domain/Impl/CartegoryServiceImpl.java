package mk.finki.ukim.mk.emtproject.service.domain.Impl;



import mk.finki.ukim.mk.emtproject.model.domain.Category;
import mk.finki.ukim.mk.emtproject.repository.CategoryRepository;
import mk.finki.ukim.mk.emtproject.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartegoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CartegoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> save(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        return categoryRepository.findById(id).map(existingCategory -> {
            if (category.getName() != null) {
                existingCategory.setName(category.getName());
            }
            if (category.getDescription() != null) {
                existingCategory.setDescription(category.getDescription());
            }
            return categoryRepository.save(existingCategory);
        });
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
