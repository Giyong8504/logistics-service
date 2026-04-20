package com.giyong.logistics.domain.product.service;

import com.giyong.logistics.domain.product.dto.ProductRequest;
import com.giyong.logistics.domain.product.dto.UpdateProductRequest;
import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.product.entity.ProductStatus;
import com.giyong.logistics.domain.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
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

    // 단일 조회
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("조회된 상품이 없습니다." +id));

    }

    // 수정
    @Transactional // 작업 단위 처리
    public Product update (Long id, UpdateProductRequest request) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 상품이 없습니다." +id));

        updateProduct.update(request.getProductNumber(),
                request.getProductName(),
                request.getPrice(),
                ProductStatus.valueOf(request.getStatus().toUpperCase()));

        return updateProduct;
    }

    // 삭제
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
