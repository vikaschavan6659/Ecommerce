package com.campusmarketplace.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    Pageable<Product> findByCategoryIgnoreCase(String category, Pageable pageable);
    Page<Product> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Product> findByCategoryAndTitleContainingIgnoreCase(String category, String title, Pageable pageable);
}
