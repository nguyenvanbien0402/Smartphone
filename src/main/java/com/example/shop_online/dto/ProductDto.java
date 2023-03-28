package com.example.shop_online.dto;

public class ProductDto {
    private  int id;
    private String name;
    private String  type;
    private float price;
    private float discout;
    private int quantity;
    private int viewCount;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ProductDto(int id, String name, String type, float price, float discout, int quantity, int viewCount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.discout = discout;
        this.quantity = quantity;
        this.viewCount = viewCount;
    }

    public ProductDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscout() {
        return discout;
    }

    public void setDiscout(float discout) {
        this.discout = discout;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
