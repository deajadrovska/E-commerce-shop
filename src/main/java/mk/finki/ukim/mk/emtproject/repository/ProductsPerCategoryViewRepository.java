package mk.finki.ukim.mk.emtproject.repository;

import mk.finki.ukim.mk.emtproject.model.views.ProductsPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsPerCategoryViewRepository
        extends JpaRepository<ProductsPerCategoryView, Long> {

    ProductsPerCategoryView findByCategoryId(Long categoryId);
}

