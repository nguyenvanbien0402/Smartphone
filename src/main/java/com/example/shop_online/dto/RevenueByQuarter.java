package com.example.shop_online.dto;

import org.springframework.beans.factory.annotation.Value;

public interface RevenueByQuarter {
    @Value("#{target.year}")
    String getYear();
    @Value("#{target.quarter}")
    String getQuarter();
    @Value("#{target.quantity}")
    int getQuantiry();
    @Value("#{target.totalRevenue}")
    float getTotalRevenue();


}
