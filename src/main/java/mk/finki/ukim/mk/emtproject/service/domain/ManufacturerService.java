package mk.finki.ukim.mk.emtproject.service.domain;

import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> findAll();

    Optional<Manufacturer> findById(Long id);

    Optional<Manufacturer> save(Manufacturer manufacturer);

    Optional<Manufacturer> update(Long id, Manufacturer manufacturer);

    void deleteById(Long id);
}
