package mk.finki.ukim.mk.emtproject.model;

import lombok.Data;

@Data
public class ProductDto {

//    no id and no object for category and manufacturer ONLY THEIR ID'S!!!!

    private String name;

    private Double price;

    private Integer quantity;

    private Long category;

    private Long manufacturer;

    public ProductDto() {
    }

    public ProductDto(String name, Double price, Integer quantity, Long category, Long manufacturer) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getCategory() {
        return category;
    }

    public Long getManufacturer() {
        return manufacturer;
    }
}
