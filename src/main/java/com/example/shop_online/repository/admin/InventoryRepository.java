package com.example.shop_online.repository.admin;

import com.example.shop_online.dto.Inventory;
import com.example.shop_online.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<ProductEntity,Integer> {

  @Query(value = " select c.name_vn as category, sum(quantity) as quantity , sum(price*quantity) as totalPrice,\n" +
          "              min(price) as minPrice, max(price) as maxPrice, avg(price) as avgPrice \n" +
          "                    from product p, category c where c.id = p.category_id  group by p.category_id\n" +
          "        ",nativeQuery = true)
    List<Inventory> getInventoryByCategory();

}
