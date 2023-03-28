package com.example.shop_online.dto;

import com.example.shop_online.entity.OrderDetailEntity;
import com.example.shop_online.model.OrderProducts;

import java.util.Date;
import java.util.List;

public class OrderDetailDto {
    private int orderId;
    private String userName;
    private Date orderDate;
    private int phone;
    private  String email;
    private String address;
    private float amount;
    private int status;

   private List<OrderProducts> listProducts;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public List<OrderProducts> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<OrderProducts> listProducts) {
        this.listProducts = listProducts;
    }
}
