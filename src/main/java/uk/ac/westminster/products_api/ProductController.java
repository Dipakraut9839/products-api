package uk.ac.westminster.products_api;
import io.swagger.v3.oas.annotations.security.SecurityRequirementEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }
    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }
    @GetMapping("/search")
    public List<Product> search(@RequestParam String name){
        return productService.findByName(name);
    }
}

//Note: With fifteen fields, I'd notice a getter is missing or misused because Spring/Jackson would either omit that field from the JSON response or throw a serialization error, making the output clearly incomplete when I test the endpoint.