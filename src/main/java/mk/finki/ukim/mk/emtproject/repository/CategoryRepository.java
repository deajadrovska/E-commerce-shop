package mk.finki.ukim.mk.emtproject.repository;


import mk.finki.ukim.mk.emtproject.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
