package com.campusmarketplace.product.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
}
