package marketplace.demo.service;

import marketplace.demo.model.Product;
import marketplace.demo.model.ProductBuilder;
import marketplace.demo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    public Product product = null;
    public List<Product> productList;

    @BeforeEach
    public void setUp() {
        product = ProductBuilder.with().name("hello").price(14.7).withDescription("DELL").build();
        productList = new ArrayList<>();
        productList.add(product);
    }

    @Test
    public void whenAddProductAllParamValidShouldReturnSuccess() {
        doReturn(product).when(productRepository).save(any());
        doReturn(productList).when(productRepository).findAll();

        productService.registerProduct(product);

        Assertions.assertEquals(product.getName(), productService.listAllProducts().get(0).getName());
    }
}
