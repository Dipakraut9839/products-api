package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        Product product = new Product();
        product.id = id;
        product.name = "Laptop";
        product.price = 999.99;

        return product;

    }



}
