package com.example.shop_online.service.admin;

import com.example.shop_online.dto.FixOrderDto;
import com.example.shop_online.dto.OrderDetailDto;
import com.example.shop_online.dto.OrderDto;
import com.example.shop_online.entity.OrderEntity;
import com.example.shop_online.payload.request.OrderRequest;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    List<OrderDetailDto> getAllOrder();
    ResponseEntity<ResponseData> deleteOrder(int id);

    ResponseEntity<ResponseData> updateOrder(int id, int status );

    ResponseEntity<OrderDto> insertOrder(OrderRequest order);


    ResponseEntity<ResponseData> deleteUserOrder(int id);

   ResponseEntity<FixOrderDto> getOrderByOrderId(int id);

   ResponseEntity<Boolean> updateOrder(OrderRequest orderRequest, int id);
   OrderDetailDto getOrderDetaiByOrderId(int id);

}
