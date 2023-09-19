package marketplace.demo.service;

import marketplace.demo.model.Product;
import marketplace.demo.model.ProductBuilder;
import marketplace.demo.model.response.ProductDto;
import marketplace.demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void registerProduct(Product product) {
        var productObject = buildProduct(product);
        addProduct(productObject);
    }

    @Override
    public List<ProductDto> listAllProducts() {
        var product = productRepository.findAll();

        return product.stream().map(p -> this.modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());

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
