package mk.finki.ukim.mk.emtproject.dto;

import mk.finki.ukim.mk.emtproject.model.domain.Category;
import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;
import mk.finki.ukim.mk.emtproject.model.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public record CreateProductDto(
        String name,
        Double price,
        Integer quantity,
        Long category,
        Long manufacturer
) {

    public static CreateProductDto from(Product product) {
        return new CreateProductDto(
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getId(),
                product.getManufacturer().getId()
        );
    }

    public static List<CreateProductDto> from(List<Product> products) {
        return products.stream().map(CreateProductDto::from).collect(Collectors.toList());
    }

    public Product toProduct(Category category, Manufacturer manufacturer) {
        return new Product(name, price, quantity, category, manufacturer);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Double price() {
        return price;
    }

    @Override
    public Integer quantity() {
        return quantity;
    }

    @Override
    public Long category() {
        return category;
    }

    @Override
    public Long manufacturer() {
        return manufacturer;
    }
}

