package com.example.shop_online.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "name_vn")
    private String nameVn;

    @JsonIgnore
    @OneToMany (mappedBy = "category")
    private List<ProductEntity> producList;

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

    public String getNameVn() {
        return nameVn;
    }

    public void setNameVn(String nameVn) {
        this.nameVn = nameVn;
    }

    public List<ProductEntity> getProducList() {
        return producList;
    }

    public void setProducList(List<ProductEntity> producList) {
        this.producList = producList;
    }
}
