package com.example.shop_online.dto;

import org.springframework.beans.factory.annotation.Value;

public interface RevenueByYear {
    @Value("#{target.year}")
    String getYear();
    @Value("#{target.quantity}")
    int getQuantiry();
    @Value("#{target.totalRevenue}")
    float getTotalPrice();

}
