package com.example.shop_online.service.admin;


import com.example.shop_online.dto.OrderDetailUserDto;
import com.example.shop_online.entity.OrderDetailEntity;
import com.example.shop_online.payload.request.OrderDetailRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.OrderDetailRepositoty;
import com.example.shop_online.repository.admin.OrderRepository;
import com.example.shop_online.repository.admin.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{


    @Autowired
    OrderDetailRepositoty orderDetailRepositoty;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseData> insertOrderDetail(OrderDetailRequest orderDetailRequest) {

        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setOrder(orderRepository.findById(orderDetailRequest.getOrderId()).get());
        orderDetailEntity.setProduct(productRepository.findById(orderDetailRequest.getId()).get());
        orderDetailEntity.setDiscount(orderDetailRequest.getDiscout());
        orderDetailEntity.setQuantity(orderDetailRequest.getQuantity());
        orderDetailEntity.setUnitPrice(orderDetailRequest.getPrice());
        ResponseData responseData ;
        OrderDetailEntity orderDetaiEntity =  orderDetailRepositoty.save(orderDetailEntity);
        if (orderDetaiEntity!=null) {
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"Đặt hàng thành công",null);
        }
        else  {
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.FALSE,"Đặt hàng thất bại",null);
        }

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> deleteOrderDetailById(int id) {
         orderDetailRepositoty.deleteById(id);
         ResponseData responseData = new ResponseData();
         responseData.setSuccess(true);
         responseData.setStatus(HttpStatus.OK.value());
         responseData.setDesc("xóa thành công");
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> updateOrderDetail(int  quantity,int id) {
           OrderDetailEntity orderDetailEntity = orderDetailRepositoty.findById(id).get();
           orderDetailEntity.setQuantity(quantity);
           orderDetailRepositoty.save(orderDetailEntity);
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }


}
