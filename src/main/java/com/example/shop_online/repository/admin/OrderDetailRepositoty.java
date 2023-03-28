package com.example.shop_online.repository.admin;

import com.example.shop_online.dto.RevenueByCategory;
import com.example.shop_online.dto.RevenueByMonth;
import com.example.shop_online.dto.RevenueByQuarter;
import com.example.shop_online.dto.RevenueByYear;
import com.example.shop_online.entity.OrderDetailEntity;
import javafx.beans.property.adapter.JavaBeanProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepositoty extends JpaRepository<OrderDetailEntity,Integer> {

    @Query(value = "  SELECT c.name_vn as category, sum(d.quantity) as quantity,sum(d.unit_price*d.quantity) as totalPrice\n" +
            "  ,min(unit_price) as minPrice,max(unit_price) as maxPrice,avg(unit_price) as avgPrice\n" +
            "  FROM (Order_detail d left join product p on d.product_id = p.id) \n" +
            "  left join category c on p.category_id = c.id \n" +
            "  GROUP BY p.category_id", nativeQuery = true)
    List<RevenueByCategory> getRevenueByCategory();

    @Query(value = "  select year(o.order_date) as year, sum(d.quantity) as quantity, sum(d.unit_price*d.quantity) as totalRevenue from order_detail d , orders o\n" +
            "  where o.id = d.order_id group by year  order by year desc ", nativeQuery = true)
    List<RevenueByYear> getRevenueByYear();


     @Query(value = "   select  year(o.order_date) as year, quarter(o.order_date) as quarter, sum(d.quantity) as quantity, \n" +
             "    sum(d.unit_price*d.quantity) as totalRevenue from order_detail d , orders o\n" +
             "  where o.id = d.order_id group by  year(o.order_date) ,quarter(o.order_date) \n" +
             "  order by  year(o.order_date) desc, quarter(o.order_date) desc", nativeQuery = true)
      List<RevenueByQuarter> getRevenueByQuarter();
    @Query(value = "   select  year(o.order_date) as year, month(o.order_date) as month, sum(d.quantity) as quantity, \n" +
            "    sum(d.unit_price*d.quantity) as totalRevenue from order_detail d , orders o\n" +
            "  where o.id = d.order_id group by  year(o.order_date) ,month(o.order_date) \n" +
            "  order by  year(o.order_date) desc, month(o.order_date) desc", nativeQuery = true)
    List<RevenueByMonth> getRevenueByMonth();
}


