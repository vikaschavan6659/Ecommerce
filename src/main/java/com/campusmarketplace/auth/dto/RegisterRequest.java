package com.campusmarketplace.auth.dto;

public record RegisterRequest(String name, String email, String password, String collegeId) {}
