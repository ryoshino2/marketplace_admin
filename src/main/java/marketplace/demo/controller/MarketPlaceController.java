package marketplace.demo.controller;


import marketplace.demo.model.Product;
import marketplace.demo.model.request.RequestBuyProduct;
import marketplace.demo.model.response.ProductDto;
import marketplace.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketPlaceController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String helloController() {
        return "hello";
    }

    @PostMapping("/register-products")
    public ResponseEntity<String> productsController(@RequestBody Product product) {
        productService.registerProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/buy-products")
    public ResponseEntity<String> buyProductsController(@RequestBody RequestBuyProduct requestBuyProduct) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listProducts")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> listProductsController() {
        return new ResponseEntity<>(productService.listAllProducts(), HttpStatus.OK);
    }


}
