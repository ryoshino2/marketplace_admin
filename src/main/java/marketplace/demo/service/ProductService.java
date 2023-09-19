package marketplace.demo.service;

import marketplace.demo.model.Product;
import marketplace.demo.model.response.ProductDto;

import java.util.List;

public interface ProductService {
    void registerProduct(Product product);
    List<ProductDto> listAllProducts();
}
