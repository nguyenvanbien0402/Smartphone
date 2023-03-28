package com.example.shop_online.dto;

import com.example.shop_online.model.OrderProducts;
import com.example.shop_online.model.UserOder;

import java.util.Date;
import java.util.List;

public class UserOderDto {
    private int orderId;
    private Date orderDate;
    private int phone;
    private String address;
    private float amount;
    private int status;
    private String description;

    private List<UserOder> listProducts;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserOder> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<UserOder> listProducts) {
        this.listProducts = listProducts;
    }
}
