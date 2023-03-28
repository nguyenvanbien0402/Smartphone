package com.example.shop_online.model;

public class FixUserOrder {

    private int productId;
    private String productName;
    private int quantity;
    private float unitPrice;
    private float discout;
    private  String photo;
    private int orDetailId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getDiscout() {
        return discout;
    }

    public void setDiscout(float discout) {
        this.discout = discout;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getOrDetailId() {
        return orDetailId;
    }

    public void setOrDetailId(int orDetailId) {
        this.orDetailId = orDetailId;
    }
}
