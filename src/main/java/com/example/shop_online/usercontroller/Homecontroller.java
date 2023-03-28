package com.example.shop_online.usercontroller;


import com.example.shop_online.dto.CategoryDto;
import com.example.shop_online.dto.ProductHomeDto;
import com.example.shop_online.dto.ProductSellingDto;
import com.example.shop_online.dto.UserOderDto;
import com.example.shop_online.entity.CategoryEntity;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.service.admin.CategoryService;
import com.example.shop_online.service.admin.ProductService;
import com.example.shop_online.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class Homecontroller {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @GetMapping("/new-product")
    public ResponseEntity<ResponseData> getNewProduct() {
        List<ProductHomeDto> list = productService.getNewProduct();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity(responseData, HttpStatus.OK);
    }

    @GetMapping("/discount-product")
    public ResponseEntity<ResponseData> getDiscountProduct() {
        List<ProductHomeDto> list = productService.getDiscountProduct();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/special-product")
    public ResponseEntity<ResponseData> getSpecialProduct() {
        List<ProductHomeDto> list = productService.getSpecialProduct();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/view-product")
    public ResponseEntity<ResponseData> getViewProduct() {
        List<ProductHomeDto> list = productService.getViewProduct();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/selling-product")
    public ResponseEntity<ResponseData> getSellingProduct() {
        List<ProductSellingDto> list = productService.getSellingProduct();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/all-home-product")
    public ResponseEntity<ResponseData> getAllHomeProduct() {
        List<ProductHomeDto> list = productService.getAllHomeProduct();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/user-category")
    public ResponseEntity<?> getAllUserCategory() {
        ResponseData responseData = new ResponseData();
        List<CategoryEntity> cateList = categoryService.getAllHomeCategory();
        List<CategoryDto> newList = new ArrayList<>();
        for (CategoryEntity data: cateList
        ) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(data.getId());
            categoryDto.setName(data.getName());
            categoryDto.setNameVn(data.getNameVn());
            newList.add(categoryDto);
        }
        responseData.setData(newList);
        responseData.setSuccess(true);
        responseData.setDesc("");
        responseData.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

     @GetMapping("/user/order/{userId}")
    public ResponseEntity<?> getUserOrder(@PathVariable(name="userId") int id) {
        List<UserOderDto> userOderDtos = userService.getUserOder(id);
        return new ResponseEntity<>(userOderDtos,HttpStatus.OK);
     }

}
