package com.example.shop_online.service.admin;

import com.example.shop_online.dto.*;
import com.example.shop_online.repository.admin.InventoryRepository;
import com.example.shop_online.repository.admin.OrderDetailRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    OrderDetailRepositoty orderDetailRepositoty;


    @Override
    public List<Inventory> getInventory() {
        return inventoryRepository.getInventoryByCategory();
    }

    @Override
    public List<RevenueByCategory> getRevenueByCategory() {
        return orderDetailRepositoty.getRevenueByCategory();
    }

    @Override
    public List<RevenueByYear> getRevenueByYear() {
        return orderDetailRepositoty.getRevenueByYear();
    }

    @Override
    public List<RevenueByQuarter> getRevenueByQuarter() {
        return orderDetailRepositoty.getRevenueByQuarter();
    }

    @Override
    public List<RevenueByMonth> getRevenueByMonth() {
        return orderDetailRepositoty.getRevenueByMonth();
    }
}
