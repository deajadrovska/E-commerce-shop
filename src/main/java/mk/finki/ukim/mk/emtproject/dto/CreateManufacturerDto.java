package mk.finki.ukim.mk.emtproject.dto;

import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;

import java.util.List;

public record CreateManufacturerDto(String name, String address) {

//    public static CreateManufacturerDto from(Manufacturer manufacturer) {
//        return new CreateManufacturerDto(manufacturer.getName(), manufacturer.getAddress());
//    }

    public Manufacturer toManufacturer() {
        return new Manufacturer(name, address);
    }

//    public static List<CreateManufacturerDto> from(List<Manufacturer> manufacturers) {
//        return manufacturers.stream().map(CreateManufacturerDto::from).toList();
//    }
}

