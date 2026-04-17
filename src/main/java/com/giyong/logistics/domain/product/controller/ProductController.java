package com.giyong.logistics.domain.product.controller;

import com.giyong.logistics.domain.product.dto.ProductResponse;
import com.giyong.logistics.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
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
}
