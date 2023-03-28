package com.example.shop_online.dto;

import org.springframework.beans.factory.annotation.Value;

public interface Inventory {
    @Value("#{target.category}")
    String getCategory();
    @Value("#{target.quantity}")
    int getQuantiry();
    @Value("#{target.totalPrice}")
    float getTotalPrice();
    @Value("#{target.minPrice}")
    float getMinPrice();
    @Value("#{target.maxPrice}")
    float getMaxPrice();
    @Value("#{target.avgPrice}")
    float getAvgPrice();

}
