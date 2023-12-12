package com.microtech.productservice.services;

import com.microtech.productservice.dto.ProductRequest;
import com.microtech.productservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
