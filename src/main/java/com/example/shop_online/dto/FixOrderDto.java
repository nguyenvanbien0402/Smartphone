package com.example.shop_online.dto;

import com.example.shop_online.model.FixUserOrder;
import com.example.shop_online.model.OrderProducts;
import com.example.shop_online.model.UserOder;

import java.util.List;

public class FixOrderDto {
    private int orderId;
    private String description;
    private int phone;
    private String address;
    private float amount;
    private List<FixUserOrder> listProducts;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<FixUserOrder> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<FixUserOrder> listProducts) {
        this.listProducts = listProducts;
    }
}
