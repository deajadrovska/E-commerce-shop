package mk.finki.ukim.mk.emtproject.service;

import mk.finki.ukim.mk.emtproject.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> findAll();

    Optional<Manufacturer> findById(Long id);

    Optional<Manufacturer> save(Manufacturer manufacturer);

    Optional<Manufacturer> update(Long id, Manufacturer manufacturer);

    void deleteById(Long id);
}
