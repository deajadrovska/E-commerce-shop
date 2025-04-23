package mk.finki.ukim.mk.emtproject.web;




import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.emtproject.dto.CreateCategoryDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayCategoryDto;
import mk.finki.ukim.mk.emtproject.service.application.CategoryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category API", description = "Endpoints for managing product categories") // OpenAPI tag
public class CategoryController {

    private final CategoryApplicationService categoryApplicationService;

    public CategoryController(CategoryApplicationService categoryApplicationService) {
        this.categoryApplicationService = categoryApplicationService;
    }

    @Operation(summary = "Get all categories", description = "Retrieves a list of all available categories.")
    @GetMapping
    public List<DisplayCategoryDto> findAll() {
        return categoryApplicationService.findAll();
    }

    @Operation(summary = "Get category by ID", description = "Finds a category by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayCategoryDto> findById(@PathVariable Long id) {
        return categoryApplicationService.findById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new category", description = "Creates a new category.")
    @PostMapping("/add")
    public ResponseEntity<DisplayCategoryDto> save(@RequestBody CreateCategoryDto createCategoryDto) {
        return categoryApplicationService.save(createCategoryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Operation(summary = "Update an existing category", description = "Updates a category by ID.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCategoryDto> update(@PathVariable Long id, @RequestBody CreateCategoryDto createCategoryDto) {
        return categoryApplicationService.update(id, createCategoryDto)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a category", description = "Deletes a category by its ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (categoryApplicationService.findById(id).isPresent()) {
            categoryApplicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

