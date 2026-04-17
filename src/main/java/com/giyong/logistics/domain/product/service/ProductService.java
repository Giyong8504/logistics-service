package com.giyong.logistics.domain.product.service;

import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 전체 조회
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
