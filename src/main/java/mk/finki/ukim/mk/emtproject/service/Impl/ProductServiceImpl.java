package mk.finki.ukim.mk.emtproject.service.Impl;

import mk.finki.ukim.mk.emtproject.model.Product;
import mk.finki.ukim.mk.emtproject.model.ProductDto;
import mk.finki.ukim.mk.emtproject.repository.CategoryRepository;
import mk.finki.ukim.mk.emtproject.repository.ProductRepository;
import mk.finki.ukim.mk.emtproject.service.ManufacturerService;
import mk.finki.ukim.mk.emtproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryService;
    private final ManufacturerService manufacturerService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryService, ManufacturerService manufacturerService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> save(ProductDto productDto) {
        if (productDto.getCategory() != null &&
                categoryService.findById(productDto.getCategory()).isPresent() &&
                productDto.getManufacturer() != null &&
                manufacturerService.findById(productDto.getManufacturer()).isPresent()) {

            return Optional.of(
                    productRepository.save(new Product(
                            productDto.getName(),
                            productDto.getPrice(),
                            productDto.getQuantity(),
                            categoryService.findById(productDto.getCategory()).get(),
                            manufacturerService.findById(productDto.getManufacturer()).get())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(Long id, ProductDto productDto) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    if (productDto.getName() != null) {
                        existingProduct.setName(productDto.getName());
                    }
                    if (productDto.getPrice() != null) {
                        existingProduct.setPrice(productDto.getPrice());
                    }
                    if (productDto.getQuantity() != null) {
                        existingProduct.setQuantity(productDto.getQuantity());
                    }

                    if (productDto.getCategory() != null) {
                        categoryService.findById(productDto.getCategory())
                                .ifPresent(existingProduct::setCategory);
                    }

                    if (productDto.getManufacturer() != null) {
                        manufacturerService.findById(productDto.getManufacturer())
                                .ifPresent(existingProduct::setManufacturer);
                    }

                    return productRepository.save(existingProduct);
                });
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
