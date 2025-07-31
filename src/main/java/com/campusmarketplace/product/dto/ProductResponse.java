package com.campusmarketplace.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private String id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    private String sellerId;
    private LocalDateTime createdAt;
}
