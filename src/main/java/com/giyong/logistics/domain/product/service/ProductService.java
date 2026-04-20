package com.giyong.logistics.domain.product.service;

import com.giyong.logistics.domain.product.dto.ProductRequest;
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

    // 저장
    public Product save(ProductRequest request) {
        return productRepository.save(request.toEntity());
    }
}
