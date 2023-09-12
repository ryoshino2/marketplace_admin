package marketplace.demo.service;

import marketplace.demo.model.Product;

import java.util.List;

public interface ProductService {
    void registerProduct(Product product);
    List<Product> listAllProducts();
}
