package com.example.shop_online.service.admin;


import com.example.shop_online.dto.OrderDetailUserDto;
import com.example.shop_online.payload.request.OrderDetailRequest;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderDetailService {



    ResponseEntity<ResponseData> insertOrderDetail(OrderDetailRequest orderDetailRequest);

    ResponseEntity<ResponseData> deleteOrderDetailById(int id);


    ResponseEntity<Boolean> updateOrderDetail(int quantity,int id);
}
