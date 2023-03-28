package com.example.shop_online.entity;


import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class   UserEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name = "password")
   private String password;
   @Column(name = "fullname")
   private String fullname;
   @Column(name = "phone")
   private  String phone;
   @Column(name = "email")
   private String email;
   @Column(name = "photo")
   private  String photo;
   @Column(name = "activated")
   private boolean activated;
   @Column(name = "admin")
   private boolean admin;

   @Column(name = "reset_password_token")
   private String resetPasswordToken;
    @OneToMany (mappedBy = "user",cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<OrderEntity> orders;

   @OneToMany (mappedBy = "user",cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
   private List<CommentEntity> commentEntities;


   public List<CommentEntity> getCommentEntities() {
      return commentEntities;
   }

   public void setCommentEntities(List<CommentEntity> commentEntities) {
      this.commentEntities = commentEntities;
   }

   public UserEntity(String fullname, String email, String password, boolean isActivated, boolean isAdmin) {
   }

   public UserEntity() {

   }

   public String getResetPasswordToken() {
      return resetPasswordToken;
   }

   public void setResetPasswordToken(String resetPasswordToken) {
      this.resetPasswordToken = resetPasswordToken;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getFullname() {
      return fullname;
   }

   public void setFullname(String fullname) {
      this.fullname = fullname;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhoto() {
      return photo;
   }

   public void setPhoto(String photo) {
      this.photo = photo;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public boolean isAdmin() {
      return admin;
   }

   public void setAdmin(boolean admin) {
      this.admin = admin;
   }

   public List<OrderEntity> getOrders() {
      return orders;
   }

   public void setOrders(List<OrderEntity> orders) {
      this.orders = orders;
   }
}
