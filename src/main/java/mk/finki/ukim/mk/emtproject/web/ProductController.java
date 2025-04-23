package mk.finki.ukim.mk.emtproject.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.emtproject.dto.CreateProductDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayProductDto;
import mk.finki.ukim.mk.emtproject.model.domain.Product;
import mk.finki.ukim.mk.emtproject.service.application.ProductApplicationService;
import mk.finki.ukim.mk.emtproject.service.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "Endpoints for managing products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @Operation(summary = "Get all products", description = "Retrieves a list of all available products.")
    @GetMapping
    public List<DisplayProductDto> findAll() {
        return productApplicationService.findAll();
    }

    @Operation(summary = "Get product by ID", description = "Finds a product by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayProductDto> findById(@PathVariable Long id) {
        return productApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Add a new product",
            description = "Creates a new product based on the given ProductDto."
    )
    @PostMapping("/add")
    public ResponseEntity<DisplayProductDto> save(@RequestBody CreateProductDto createProductDto) {
        return productApplicationService.save(createProductDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // todo: refactor product update functionality
    @Operation(
            summary = "Update an existing product", description = "Updates a product by ID using ProductDto."
    )
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayProductDto> update(
            @PathVariable Long id,
            @RequestBody CreateProductDto product
    ) {
        return productApplicationService.update(id, product)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a product", description = "Deletes a product by its ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (productApplicationService.findById(id).isPresent()) {
            productApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

