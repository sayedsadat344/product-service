package com.microtech.productservice.services.implementations;

import com.microtech.productservice.dto.ProductRequest;
import com.microtech.productservice.dto.ProductResponse;
import com.microtech.productservice.models.Product;
import com.microtech.productservice.respositories.ProductRepository;
import com.microtech.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImplementation implements ProductService {

    public final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {

        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(newProduct);
        log.info("Product with id {} is created!", newProduct.getId());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Products retrived of size {} !", products.size());
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
