package com.example.shop_online.repository.admin;

import com.example.shop_online.dto.ProductHomeDto;
import com.example.shop_online.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select p.* FROM Product p where p.available = true ORDER BY p.create_date DESC limit 10",nativeQuery = true)
    List<ProductEntity> getNewProduct();


    @Query(value = "select p.* FROM  Product p where p.available = true ORDER BY p.discount DESC  ",nativeQuery = true)
    List<ProductEntity> getDiscountProduct();



    @Query(value = "select p.* FROM  Product p where p.available = true and p.special = true   ",nativeQuery = true)
    List<ProductEntity> getSpecialProduct();


    @Query(value = "select p.* FROM  Product p where p.available = true ORDER BY p.view_count desc limit 10   ",nativeQuery = true)
    List<ProductEntity> getViewProduct();


    @Query(value = "select p.* FROM  Product p where p.available = true    ",nativeQuery = true)
    List<ProductEntity> getSellingProduct();

    @Query(value = "select p.*  from Product p where p.name like %?1% ", nativeQuery = true)
    List<ProductEntity> getSeachProduct(String search);
}
