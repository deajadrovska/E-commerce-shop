package mk.finki.ukim.mk.emtproject.repository;


import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
