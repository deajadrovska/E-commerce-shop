package mk.finki.ukim.mk.emtproject.dto;

import mk.finki.ukim.mk.emtproject.model.domain.Category;

import java.util.List;

public record DisplayCategoryDto(Long id, String name, String description) {

    public static DisplayCategoryDto from(Category category) {
        return new DisplayCategoryDto(category.getId(), category.getName(), category.getDescription());
    }


    public static List<DisplayCategoryDto> from(List<Category> categories) {
        return categories.stream().map(DisplayCategoryDto::from).toList();
    }
}

