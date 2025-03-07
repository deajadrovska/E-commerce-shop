package mk.finki.ukim.mk.emtproject.repository;


import mk.finki.ukim.mk.emtproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
