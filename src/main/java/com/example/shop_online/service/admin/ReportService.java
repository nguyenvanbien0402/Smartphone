package com.example.shop_online.service.admin;

import com.example.shop_online.dto.*;

import java.util.List;

public interface ReportService {
    List<Inventory> getInventory();

    List<RevenueByCategory> getRevenueByCategory();

    List<RevenueByYear> getRevenueByYear();

    List<RevenueByQuarter> getRevenueByQuarter();

    List<RevenueByMonth> getRevenueByMonth();
}
