package controller;


import dto.ProductDto;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }


    @PostMapping("/")
    public ProductDto save(@RequestBody Product product){
       return productService.save(product);
    }
}
