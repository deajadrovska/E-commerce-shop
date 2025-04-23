package mk.finki.ukim.mk.emtproject.dto;

import mk.finki.ukim.mk.emtproject.model.domain.Category;
import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;
import mk.finki.ukim.mk.emtproject.model.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayProductDto(
        Long id,
        String name,
        Double price,
        Integer quantity,
        Long category,
        Long manufacturer
) {

    public static DisplayProductDto from(Product product) {
        return new DisplayProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getId(),
                product.getManufacturer().getId()
        );
    }

    public static List<DisplayProductDto> from(List<Product> products) {
        return products.stream().map(DisplayProductDto::from).collect(Collectors.toList());
    }

    public Product toProduct(Category category, Manufacturer manufacturer) {
        return new Product(name, price, quantity, category, manufacturer);
    }
}

