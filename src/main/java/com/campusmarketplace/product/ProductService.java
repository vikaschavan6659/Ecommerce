package com.campusmarketplace.product;

import com.campusmarketplace.product.dto.ProductRequest;
import com.campusmarketplace.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product updated) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setCategory(updated.getCategory());
        existing.setImageUrl(updated.getImageUrl());
        existing.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(existing);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Product getById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts(String category, String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (category != null && search != null) {
            return productRepository.findByCategoryAndTitleContainingIgnoreCase(category, search, pageable).getContent();
        } else if (category != null) {
            return productRepository.findByCategoryIgnoreCase(category, pageable).getContent();
        } else if (search != null) {
            return productRepository.findByTitleContainingIgnoreCase(search, pageable).getContent();
        } else {
            return productRepository.findAll(pageable).getContent();
        }
    }
}
