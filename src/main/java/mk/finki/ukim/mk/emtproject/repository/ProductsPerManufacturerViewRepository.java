package mk.finki.ukim.mk.emtproject.repository;

import mk.finki.ukim.mk.emtproject.model.views.ProductsPerManufacturerView;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsPerManufacturerViewRepository
        extends JpaRepository<ProductsPerManufacturerView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.products_per_manufacturers", nativeQuery = true)
    void refreshMaterializedView();
}

