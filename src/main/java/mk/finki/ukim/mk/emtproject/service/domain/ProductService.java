package mk.finki.ukim.mk.emtproject.service.domain;

import mk.finki.ukim.mk.emtproject.model.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> save(Product product);

    Optional<Product> update(Long id, Product product);

    void deleteById(Long id);

    void refreshMaterializedView();
}
