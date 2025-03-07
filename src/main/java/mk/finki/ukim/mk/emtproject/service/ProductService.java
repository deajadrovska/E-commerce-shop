package mk.finki.ukim.mk.emtproject.service;

import mk.finki.ukim.mk.emtproject.model.Product;
import mk.finki.ukim.mk.emtproject.model.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> save(ProductDto productDto);

    Optional<Product> update(Long id, ProductDto productDto);

    void deleteById(Long id);
}
