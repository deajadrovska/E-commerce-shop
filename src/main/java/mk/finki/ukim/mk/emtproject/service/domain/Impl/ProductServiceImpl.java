package mk.finki.ukim.mk.emtproject.service.domain.Impl;

import mk.finki.ukim.mk.emtproject.model.domain.Product;
import mk.finki.ukim.mk.emtproject.repository.CategoryRepository;
import mk.finki.ukim.mk.emtproject.repository.ProductRepository;
import mk.finki.ukim.mk.emtproject.repository.ProductsPerManufacturerViewRepository;
import mk.finki.ukim.mk.emtproject.service.domain.CategoryService;
import mk.finki.ukim.mk.emtproject.service.domain.ManufacturerService;
import mk.finki.ukim.mk.emtproject.service.domain.ProductService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;
    private final ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ProductServiceImpl(
            ProductRepository productRepository,
            ManufacturerService manufacturerService,
            CategoryService categoryService,
            ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository,
            ApplicationEventPublisher applicationEventPublisher
    ) {
        this.productRepository = productRepository;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
        this.productsPerManufacturerViewRepository = productsPerManufacturerViewRepository;
        this.applicationEventPublisher = applicationEventPublisher;
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
    public Optional<Product> update(Long id, Product product) {
        return productRepository.findById(id).map(existingProduct -> {
            if (product.getName() != null) {
                existingProduct.setName(product.getName());
            }
            if (product.getPrice() != null) {
                existingProduct.setPrice(product.getPrice());
            }
            if (product.getQuantity() != null) {
                existingProduct.setQuantity(product.getQuantity());
            }
            if (product.getCategory() != null && categoryService.findById(product.getCategory().getId()).isPresent()) {
                existingProduct.setCategory(categoryService.findById(product.getCategory().getId()).get());
            }
            if (product.getManufacturer() != null && manufacturerService.findById(product.getManufacturer().getId())
                    .isPresent()) {
                existingProduct.setManufacturer(manufacturerService.findById(product.getManufacturer().getId()).get());
            }
            Product updatedProduct = productRepository.save(existingProduct);

            this.refreshMaterializedView();
            //            this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));

            return updatedProduct;
        });
    }

    @Override
    public Optional<Product> save(Product product) {
        Optional<Product> savedProduct = Optional.empty();

        if (product.getCategory() != null && categoryService.findById(product.getCategory().getId())
                .isPresent() && product.getManufacturer()
                .getId() != null && manufacturerService.findById(
                product.getManufacturer().getId()).isPresent()) {
            savedProduct = Optional.of(productRepository.save(new Product(
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    categoryService.findById(product.getCategory().getId()).get(),
                    manufacturerService.findById(product.getManufacturer().getId()).get()
            )));
            this.refreshMaterializedView();
            //        this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        }
        return savedProduct;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void refreshMaterializedView() {
        productsPerManufacturerViewRepository.refreshMaterializedView();
    }
}


