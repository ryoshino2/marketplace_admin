package marketplace.demo.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void whenBuildProductAllParamValidShouldReturnSuccess() {

        Product product = ProductBuilder.with().name("hello").price("world").withDescription("DELL").build();
        Assertions.assertEquals("hello", product.getName());
        Assertions.assertEquals("world", product.getPrice());
        Assertions.assertEquals("DELL", product.getDescription());
    }

    @Test
    public void whenBuildProductOnlyRequiredParamShouldReturnSuccess() {

        Product product = ProductBuilder.with().name("hello").price("world").build();
        Assertions.assertEquals("hello", product.getName());
        Assertions.assertEquals("world", product.getPrice());
    }
}
