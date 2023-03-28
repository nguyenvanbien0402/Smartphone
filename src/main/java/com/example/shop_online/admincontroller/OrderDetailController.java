package com.example.shop_online.admincontroller;


import com.example.shop_online.payload.request.OrderDetailRequest;
import com.example.shop_online.service.admin.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;
    @PostMapping("/insert-order-detail-product")
    public ResponseEntity<?> insertOderDetailProduct(@RequestBody OrderDetailRequest orderDetailRequest)
    {
      return   orderDetailService.insertOrderDetail(orderDetailRequest);
    }

    @DeleteMapping("/delete-order-detail/{id}")
    public ResponseEntity<?> deleteOrderDetailById(@PathVariable(name = "id") int id)
    {
     return    orderDetailService.deleteOrderDetailById(id);
    }


    @PutMapping("/update-order-detail/{id}")
    public ResponseEntity<?> updateOrderDetail(@RequestParam(name = "quantity") int quantity,@PathVariable(name = "id") int id) {
        return orderDetailService.updateOrderDetail(quantity,id);
    }
}
