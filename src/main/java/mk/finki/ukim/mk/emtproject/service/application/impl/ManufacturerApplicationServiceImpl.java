package mk.finki.ukim.mk.emtproject.service.application.impl;

import mk.finki.ukim.mk.emtproject.dto.CreateManufacturerDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayManufacturerDto;
import mk.finki.ukim.mk.emtproject.service.application.ManufacturerApplicationService;
import mk.finki.ukim.mk.emtproject.service.domain.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerApplicationServiceImpl implements ManufacturerApplicationService {

    private final ManufacturerService manufacturerService;

    public ManufacturerApplicationServiceImpl(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @Override
    public List<DisplayManufacturerDto> findAll() {
        return DisplayManufacturerDto.from(manufacturerService.findAll());
    }

    @Override
    public Optional<DisplayManufacturerDto> findById(Long id) {
        return manufacturerService.findById(id).map(DisplayManufacturerDto::from);
    }

    @Override
    public Optional<DisplayManufacturerDto> update(Long id, CreateManufacturerDto manufacturer) {
        return manufacturerService.update(id, manufacturer.toManufacturer())
                .map(DisplayManufacturerDto::from);
    }

    @Override
    public void deleteById(Long id) {
        manufacturerService.deleteById(id);
    }

    @Override
    public Optional<DisplayManufacturerDto> save(CreateManufacturerDto createManufacturerDto) {
        return manufacturerService.save(createManufacturerDto.toManufacturer())
                .map(DisplayManufacturerDto::from);
    }
}

