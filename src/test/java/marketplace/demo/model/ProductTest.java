package marketplace.demo.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void whenBuildProductAllParamValidShouldReturnSuccess() {

        Product product = ProductBuilder.with().name("hello").price(11.2).withDescription("DELL").build();
        Assertions.assertEquals("hello", product.getName());
        Assertions.assertEquals(11.2, product.getPrice());
        Assertions.assertEquals("DELL", product.getDescription());
    }

    @Test
    public void whenBuildProductOnlyRequiredParamShouldReturnSuccess() {

        Product product = ProductBuilder.with().name("hello").price(14.2).build();
        Assertions.assertEquals("hello", product.getName());
        Assertions.assertEquals(14.2, product.getPrice());
    }
}
