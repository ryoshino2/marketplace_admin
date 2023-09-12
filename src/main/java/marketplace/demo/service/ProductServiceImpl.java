package marketplace.demo.service;

import marketplace.demo.model.Product;
import marketplace.demo.model.ProductBuilder;
import marketplace.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void registerProduct(Product product) {
        var productObject = buildProduct(product);
        addProduct(productObject);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    private void addProduct(Product product) {
        productRepository.save(product);
    }

    private Product buildProduct(Product product) {
        var productObject = new Product();
        if (product.getDescription().isEmpty()) {
            productObject = ProductBuilder.with().name(product.getName()).price(product.getPrice()).build();
        } else {
            productObject = ProductBuilder.with().name(product.getName()).price(product.getPrice()).withDescription(product.getDescription()).build();
        }
        return productObject;
    }
}
