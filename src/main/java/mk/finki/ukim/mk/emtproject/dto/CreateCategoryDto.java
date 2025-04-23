package mk.finki.ukim.mk.emtproject.dto;

import mk.finki.ukim.mk.emtproject.model.domain.Category;

import java.util.List;

public record CreateCategoryDto(String name, String description) {

    public static CreateCategoryDto from(Category category) {
        return new CreateCategoryDto(category.getName(), category.getDescription());
    }

    public Category toCategory() {
        return new Category(name, description);
    }

    public static List<CreateCategoryDto> from(List<Category> categories) {
        return categories.stream().map(CreateCategoryDto::from).toList();
    }
}

