package mk.finki.ukim.mk.emtproject.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.emtproject.model.domain.Category;
import mk.finki.ukim.mk.emtproject.model.domain.Manufacturer;
import mk.finki.ukim.mk.emtproject.model.domain.User;
import mk.finki.ukim.mk.emtproject.model.enumerations.Role;
import mk.finki.ukim.mk.emtproject.repository.CategoryRepository;
import mk.finki.ukim.mk.emtproject.repository.ManufacturerRepository;
import mk.finki.ukim.mk.emtproject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            CategoryRepository categoryRepository,
            ManufacturerRepository manufacturerRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostConstruct
    public void init() {
//        categoryRepository.save(new Category("Sports", "Sports category"));
        categoryRepository.save(new Category("Food", "Food category"));
        categoryRepository.save(new Category("Music", "Music category"));

//        manufacturerRepository.save(new Manufacturer("Nike", "USA"));
        manufacturerRepository.save(new Manufacturer("KFC", "USA"));
        manufacturerRepository.save(new Manufacturer("A Records", "UK"));

        userRepository.save(new User(
                "dj",
                passwordEncoder.encode("dj"),
                "Dea",
                "Jadrovska",
                Role.ROLE_ADMIN
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.ROLE_USER
        ));
    }
}

