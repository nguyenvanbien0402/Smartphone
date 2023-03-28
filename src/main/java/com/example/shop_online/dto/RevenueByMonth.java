package com.example.shop_online.dto;

import org.springframework.beans.factory.annotation.Value;

public interface RevenueByMonth {
    @Value("#{target.year}")
    String getYear();
    @Value("#{target.month}")
    String getMonth();
    @Value("#{target.quantity}")
    int getQuantiry();
    @Value("#{target.totalRevenue}")
    float getTotalRevenue();

}
