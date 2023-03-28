package com.example.shop_online.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "photo")
    private String photo;

    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "available")
    private boolean available;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "discount")
    private float discount;
    @Column(name = "view_count")
    private int viewCount;
    @Column(name = "special")
    private boolean special;

    @ManyToOne()
    @JoinColumn(name = "category_id" )
     private CategoryEntity category;

   @OneToMany(mappedBy = "product",cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<OrderDetailEntity> orderDetailEntities;


    @OneToMany(mappedBy = "product",cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<CommentEntity> commentEntities;


    public ProductEntity(int id, String name, float price, String photo, Date createDate, boolean available, int quantity, String description, float discount, int viewCount, boolean special, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.createDate = createDate;
        this.available = available;
        this.quantity = quantity;
        this.description = description;
        this.discount = discount;
        this.viewCount = viewCount;
        this.special = special;
        this.category = category;
    }

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public ProductEntity() {
    }

    public ProductEntity(String name, float price, Date createDate, boolean available, int quantity, String description, int viewCount, String description1, float discount, boolean special) {
    }

    public ProductEntity(String name, float price, Date createDate, boolean available, int quantity, String description, int viewCount, float discount, boolean special) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
        this.orderDetailEntities = orderDetailEntities;
    }
}
