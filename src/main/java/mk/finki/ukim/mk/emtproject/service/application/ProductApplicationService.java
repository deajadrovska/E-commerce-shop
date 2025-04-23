package mk.finki.ukim.mk.emtproject.service.application;

import mk.finki.ukim.mk.emtproject.dto.CreateProductDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductApplicationService {

    Optional<DisplayProductDto> update(Long id, CreateProductDto productDto) ;

    Optional<DisplayProductDto> save(CreateProductDto productDto);

    Optional<DisplayProductDto> findById(Long id);

    List<DisplayProductDto> findAll();

    void deleteById(Long id);
}

