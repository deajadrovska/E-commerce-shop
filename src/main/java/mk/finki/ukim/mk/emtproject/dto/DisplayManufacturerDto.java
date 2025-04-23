package mk.finki.ukim.mk.emtproject.dto;

import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;

import java.util.List;

public record DisplayManufacturerDto(Long id, String name, String address) {

    public static DisplayManufacturerDto from(Manufacturer manufacturer) {
        return new DisplayManufacturerDto(manufacturer.getId(), manufacturer.getName(), manufacturer.getAddress());
    }

    public Manufacturer toManufacturer() {
        return new Manufacturer(name, address);
    }

    public static List<DisplayManufacturerDto> from(List<Manufacturer> manufacturers) {
        return manufacturers.stream().map(DisplayManufacturerDto::from).toList();
    }
}

