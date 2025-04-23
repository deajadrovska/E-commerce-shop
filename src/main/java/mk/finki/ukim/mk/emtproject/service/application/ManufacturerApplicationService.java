package mk.finki.ukim.mk.emtproject.service.application;

import mk.finki.ukim.mk.emtproject.dto.CreateManufacturerDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayManufacturerDto;

import java.util.List;
import java.util.Optional;

public interface ManufacturerApplicationService {

    List<DisplayManufacturerDto> findAll();

    Optional<DisplayManufacturerDto> findById(Long id);

    Optional<DisplayManufacturerDto> save(CreateManufacturerDto manufacturer);

    Optional<DisplayManufacturerDto> update(Long id, CreateManufacturerDto manufacturer);

    void deleteById(Long id);
}

