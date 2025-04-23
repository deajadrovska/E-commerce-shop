package mk.finki.ukim.mk.emtproject.service.application;

import mk.finki.ukim.mk.emtproject.dto.CreateCategoryDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayCategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryApplicationService {

    List<DisplayCategoryDto> findAll();

    Optional<DisplayCategoryDto> save(CreateCategoryDto category);

    Optional<DisplayCategoryDto> findById(Long id);

    Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto category);

    void deleteById(Long id);
}

