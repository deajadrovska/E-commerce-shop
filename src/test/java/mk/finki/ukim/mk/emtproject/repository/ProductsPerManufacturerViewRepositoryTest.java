package mk.finki.ukim.mk.emtproject.repository;

import mk.finki.ukim.mk.emtproject.model.domain.Product;
import mk.finki.ukim.mk.emtproject.model.views.ProductsPerManufacturerView;
import mk.finki.ukim.mk.emtproject.service.domain.CategoryService;
import mk.finki.ukim.mk.emtproject.service.domain.ManufacturerService;
import mk.finki.ukim.mk.emtproject.service.domain.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerManufacturerViewRepositoryTest {

    @Autowired
    private ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    //todo: improve testing
    @Test
    public void testCreateNewProduct() {
        List<ProductsPerManufacturerView> list1 = this.productsPerManufacturerViewRepository.findAll();

        Product product = new Product();
        product.setName("Ski Jacket 557");
        product.setManufacturer(this.manufacturerService.findAll().get(2));
        product.setCategory(this.categoryService.findAll().get(1));
        this.productService.save(product);

        List<ProductsPerManufacturerView> list2 = this.productsPerManufacturerViewRepository.findAll();
    }
}
