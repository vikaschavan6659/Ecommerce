package com.campusmarketplace.product;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String sellerId;
    private String category;
    private LocalDateTime createdAt;
}
