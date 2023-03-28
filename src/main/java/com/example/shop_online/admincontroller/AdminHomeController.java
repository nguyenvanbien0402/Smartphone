package com.example.shop_online.admincontroller;


import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.ProductRepository;
import com.example.shop_online.service.admin.AdminHomeService;
import com.example.shop_online.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AdminHomeController {

    @Autowired
    AdminHomeService adminHomeService;
    @Autowired
    ProductService productService;



    @GetMapping("/amount-user")
    public ResponseEntity<?> getAmountUser() {
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",adminHomeService.getAmountUser());
        return new ResponseEntity<>( responseData, HttpStatus.OK);
    }



    @GetMapping("/amount-category")
    public ResponseEntity<?> getAmountCategory(){
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",adminHomeService.getAmountCategory());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/amount-product")
    public ResponseEntity<?> getAmountProduct(){
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",adminHomeService.getAmountProducts());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
    @GetMapping("/amount-order")
    public ResponseEntity<?> getAmountOrder(){
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",adminHomeService.getAmountOrder());
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
}
