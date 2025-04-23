package mk.finki.ukim.mk.emtproject.repository;

import mk.finki.ukim.mk.emtproject.model.views.ProductsPerCategoryView;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerCategoryViewRepositoryTest {

    @Autowired
    private ProductsPerCategoryViewRepository productsPerCategoryViewRepository;

//    @Test
//    public void testFindAll() {
//        Assert.assertEquals(3, this.productsPerCategoryViewRepository.findByCategoryId(1L)
//                .getNumProducts().intValue());
//    }

    @Test
    public void testBasicFunctionality() {
        List<ProductsPerCategoryView> views = productsPerCategoryViewRepository.findAll();
        Assertions.assertFalse(views.isEmpty());

        if (!views.isEmpty()) {
            ProductsPerCategoryView view = views.get(0);
            // Print class details to debug
            System.out.println("View class: " + view.getClass().getName());
            System.out.println("View properties: " + view.toString());
        }
    }
}

