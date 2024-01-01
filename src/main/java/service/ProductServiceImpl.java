package service;


import dto.ProductDto;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {





    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map((product) ->
                new ProductDto(product.getId(),product.getTitle()) ).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(long id) {
       Optional<Product> productOptional= productRepository.findById(id);
       if(productOptional.isPresent()){
           Product product =productOptional.get();
           return new ProductDto(product.getId(),product.getTitle());
       }
       throw new RuntimeException("Product given id"+ id);
    }

    @Override
    public ProductDto save(Product product) {
     Product  savedProduct = productRepository.save(product);
     return new ProductDto(savedProduct.getId(),savedProduct.getTitle());
    }

    @Override
    public ProductDto remove(long id) {
        ProductDto productDto = findById(id);
        productRepository.deleteById(productDto.id());
        return productDto;
    }
}
