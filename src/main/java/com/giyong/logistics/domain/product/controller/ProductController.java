package com.giyong.logistics.domain.product.controller;

import com.giyong.logistics.domain.product.dto.ProductRequest;
import com.giyong.logistics.domain.product.dto.ProductResponse;
import com.giyong.logistics.domain.product.entity.Product;
import com.giyong.logistics.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // 전체조회
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> findAll = productService.findAll()
                .stream().map(ProductResponse::new).toList();

        return ResponseEntity.ok().body(findAll); // 200 응답과 함께 body에 담아 반환
    }

    // 저장
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductRequest request) {
        Product saveProduct = productService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    // 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product findById = productService.findById(id);

        return ResponseEntity.ok().body(new ProductResponse(findById));
    }

    // 등록 상품 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);

        return ResponseEntity.ok().build();
    }
}
