package com.example.shop_online.service.admin;


import com.example.shop_online.dto.FixOrderDto;
import com.example.shop_online.dto.OrderDetailDto;
import com.example.shop_online.dto.OrderDto;
import com.example.shop_online.entity.OrderDetailEntity;
import com.example.shop_online.entity.OrderEntity;
import com.example.shop_online.model.FixUserOrder;
import com.example.shop_online.model.OrderProducts;
import com.example.shop_online.model.UserOder;
import com.example.shop_online.payload.request.OrderRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.OrderRepository;
import com.example.shop_online.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<OrderDetailDto> getAllOrder() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        for (OrderEntity data: orderEntityList
             ) {
            List<OrderProducts> list = new ArrayList<>();
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setOrderId(data.getId());
            orderDetailDto.setOrderDate(data.getOrderDate());
            orderDetailDto.setPhone(data.getPhone());
            orderDetailDto.setAddress(data.getAddress());
            orderDetailDto.setAmount(data.getAmount());
            orderDetailDto.setStatus(data.getStatus());
            orderDetailDto.setEmail(data.getUser().getEmail());
            orderDetailDto.setUserName(data.getUser().getFullname());
           List<OrderDetailEntity> orderDetailList = data.getOrderDetails();
           if (orderDetailList.size()>0) {
               for (OrderDetailEntity dt: orderDetailList
               ) {
                   OrderProducts orderProducts = new OrderProducts();
                   orderProducts.setProductName(dt.getProduct().getName());
                   orderProducts.setUnitPrice(dt.getUnitPrice());
                   orderProducts.setQuantity(dt.getQuantity());
                   list.add(orderProducts);
               }
           } else {
               list = null;
           }

           orderDetailDto.setListProducts(list);
           orderDetailDtos.add(orderDetailDto);
        }
        return orderDetailDtos;
    }

    @Override
    public ResponseEntity<ResponseData> deleteOrder(int id) {
        orderRepository.deleteById(id);
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"delete suscessfully",null);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> updateOrder(int id,int status) {
        OrderEntity order = orderRepository.findById(id).get();
        ResponseData responseData;
        if (order != null) {
            order.setStatus(status);
            orderRepository.save(order);
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"update suscessfully",null);
        }
        else {
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.FALSE,"update faild, not found ",null);
        }

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> insertOrder(OrderRequest order) {

        OrderEntity order1 = new OrderEntity();
        order1.setUser(userRepository.findById(order.getUserId()).get());
        order1.setOrderDate(order.getOrderDate());
        order1.setAddress(order.getAddress());
        order1.setAmount(order.getAmount());
        order1.setPhone(order.getPhone());
        order1.setDescription(order.getDescription());
        order1.setStatus(order.getStatus());
        OrderEntity orderEntity = orderRepository.save(order1);


        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(orderEntity.getId());
        orderDto.setUserId(orderEntity.getUser().getId());
        orderDto.setDescription(orderEntity.getDescription());
        orderDto.setAmount(orderEntity.getAmount());
        orderDto.setAddress(orderEntity.getAddress());
        orderDto.setStatus(orderEntity.getStatus());
        orderDto.setPhone(orderEntity.getPhone());
        orderDto.setOrderDate(orderEntity.getOrderDate());

        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> deleteUserOrder(int id) {
           ResponseData responseData  = new ResponseData();
           orderRepository.deleteById(id);
           responseData.setDesc("xóa thành công");
           responseData.setStatus(HttpStatus.OK.value());
           responseData.setSuccess(true);

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FixOrderDto> getOrderByOrderId(int id) {
        OrderEntity order = orderRepository.findById(id).get();
        FixOrderDto fixOrderDto = new FixOrderDto();
        fixOrderDto.setOrderId(id);
        fixOrderDto.setAddress(order.getAddress());
        fixOrderDto.setDescription(order.getDescription());
        fixOrderDto.setAmount(order.getAmount());
        fixOrderDto.setPhone(order.getPhone());
        List<OrderDetailEntity> list = order.getOrderDetails();
        List<FixUserOrder> userOderList = new ArrayList<>();
        for (OrderDetailEntity data: list
             ) {
            FixUserOrder userOder = new FixUserOrder();
            userOder.setPhoto(data.getProduct().getPhoto());
            userOder.setProductName(data.getProduct().getName());
            userOder.setDiscout(data.getDiscount());
            userOder.setUnitPrice(data.getUnitPrice());
            userOder.setQuantity(data.getQuantity());
            userOder.setOrDetailId(data.getId());
            userOder.setProductId(data.getProduct().getId());
            userOderList.add(userOder);
        }
        fixOrderDto.setListProducts(userOderList);
        return new ResponseEntity<>(fixOrderDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> updateOrder(OrderRequest orderRequest, int id) {

        OrderEntity order = orderRepository.findById(id).get();
        order.setDescription(orderRequest.getDescription());
        order.setAmount(orderRequest.getAmount());
        order.setAddress(orderRequest.getAddress());
        order.setPhone(orderRequest.getPhone());
        order.setOrderDate(orderRequest.getOrderDate());
        orderRepository.save(order);

        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }

    @Override
    public OrderDetailDto getOrderDetaiByOrderId(int id) {
        List<OrderProducts> list = new ArrayList<>();
        OrderEntity order = orderRepository.findById(id).get();
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setAddress(order.getAddress());
        orderDetailDto.setStatus(order.getStatus());
        orderDetailDto.setPhone(order.getPhone());
        orderDetailDto.setAmount(order.getAmount());
        orderDetailDto.setOrderDate(order.getOrderDate());
        orderDetailDto.setUserName(order.getUser().getFullname());
        orderDetailDto.setEmail(order.getUser().getEmail());
        orderDetailDto.setOrderId(order.getId());

        List<OrderDetailEntity> orderDetailEntities = order.getOrderDetails();

        if (orderDetailEntities.size()>0) {
            for (OrderDetailEntity dt: orderDetailEntities
            ) {
                OrderProducts orderProducts = new OrderProducts();
                orderProducts.setProductName(dt.getProduct().getName());
                orderProducts.setUnitPrice(dt.getUnitPrice());
                orderProducts.setQuantity(dt.getQuantity());
                list.add(orderProducts);
            }
        } else {
            list = null;
        }
        orderDetailDto.setListProducts(list);

        return orderDetailDto;
    }
}
