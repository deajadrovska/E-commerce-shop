package mk.finki.ukim.mk.emtproject.service.application.impl;

import mk.finki.ukim.mk.emtproject.model.domain.Category;
import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;
import mk.finki.ukim.mk.emtproject.service.application.ProductApplicationService;
import mk.finki.ukim.mk.emtproject.service.domain.CategoryService;
import mk.finki.ukim.mk.emtproject.service.domain.ManufacturerService;
import mk.finki.ukim.mk.emtproject.service.domain.ProductService;
import org.springframework.stereotype.Service;
import mk.finki.ukim.mk.emtproject.dto.DisplayProductDto;
import mk.finki.ukim.mk.emtproject.dto.CreateProductDto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    public ProductApplicationServiceImpl(
            ProductService productService,
            ManufacturerService manufacturerService,
            CategoryService categoryService
    ) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
    }

    @Override
    public Optional<DisplayProductDto> findById(Long id) {
        return productService.findById(id).map(DisplayProductDto::from);
    }

    @Override
    public List<DisplayProductDto> findAll() {
        return productService.findAll().stream().map(DisplayProductDto::from).toList();
    }

    @Override
    public Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto) {
        Optional<Manufacturer> manufacturer = manufacturerService.findById(createProductDto.manufacturer());
        Optional<Category> category = categoryService.findById(createProductDto.category());

        return productService.update(id,
                        createProductDto.toProduct(
                                category.orElse(null),
                                manufacturer.orElse(null)
                        )
                )
                .map(DisplayProductDto::from);
    }

    @Override
    public Optional<DisplayProductDto> save(CreateProductDto createProductDto) {
        Optional<Manufacturer> manufacturer = manufacturerService.findById(createProductDto.manufacturer());
        Optional<Category> category = categoryService.findById(createProductDto.category());

        if (manufacturer.isPresent() && category.isPresent()) {
            return productService.save(createProductDto.toProduct(category.get(), manufacturer.get()))
                    .map(DisplayProductDto::from);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        productService.deleteById(id);
    }
}

