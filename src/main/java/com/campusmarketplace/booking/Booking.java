package com.campusmarketplace.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String id;

    private String userId;
    private String hotelId;

    private LocalDate bookingDate;
    private String timeSlot; // e.g., "7:00 PM - 9:00 PM"

    private int numberOfGuests;
    private String status; // e.g., PENDING, CONFIRMED, CANCELLED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

