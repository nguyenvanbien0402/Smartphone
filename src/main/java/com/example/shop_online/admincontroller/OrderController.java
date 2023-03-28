package com.example.shop_online.admincontroller;


import com.example.shop_online.dto.OrderDetailDto;
import com.example.shop_online.entity.OrderEntity;
import com.example.shop_online.payload.request.OrderRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.service.admin.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all-order")
    public ResponseEntity<?> getOrderDetai() {
        List<OrderDetailDto> orderDetail = orderService.getAllOrder();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",orderDetail);
        return new ResponseEntity<>(responseData,HttpStatus.OK);

    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(name = "id") int id) {
       return orderService.deleteOrder(id);
    }

    @PutMapping("/update-order/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable(name = "id") int id,@RequestParam(name = "status") int status) {
        return orderService.updateOrder(id,status);
    }

    @PostMapping("/insert-order")
    public ResponseEntity<?>insertOder(@RequestBody OrderRequest order) {
        return   orderService.insertOrder(order);
    }

    @DeleteMapping("/delete-user-order/{orderId}")
    public ResponseEntity<?> deleteUserOrder(@PathVariable(name="orderId") int orderId) {
        return orderService.deleteUserOrder(orderId);
    }


    @GetMapping("/user-order-fix/{id}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable(name = "id") int orderId)
    {
        return orderService.getOrderByOrderId(orderId);
    }


    @PutMapping("/update-user-order/{id}")
    public ResponseEntity<?> updateUserOrder(@RequestBody OrderRequest orderRequest,@PathVariable(name = "id") int id)
    {
        return orderService.updateOrder(orderRequest,id);
    }

    @GetMapping("/get-order-by-order-id/{id}")
    public  OrderDetailDto getOrderDetailByOrderId(@PathVariable(name="id") int id)
    {
        return orderService.getOrderDetaiByOrderId(id);
    }
}
