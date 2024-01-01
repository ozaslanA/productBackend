package service;

import dto.ProductDto;
import entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(long id);
    ProductDto save(Product product);
    ProductDto remove (long id);
}
