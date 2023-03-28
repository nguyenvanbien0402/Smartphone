package com.example.shop_online.service.admin;


import com.example.shop_online.dto.CategoryDto;
import com.example.shop_online.dto.OrderDetailDto;
import com.example.shop_online.dto.ProductDto;
import com.example.shop_online.dto.UserDto;
import com.example.shop_online.entity.CategoryEntity;
import com.example.shop_online.entity.OrderEntity;
import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.repository.admin.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminHomeServiceImpl implements AdminHomeService{

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderService orderService;



    @Override
    public int getAmountUser() {
        List<UserDto> list = userService.getAllUser();

        return list.size();
    }



    @Override
    public int getAmountCategory() {
        List<CategoryEntity> list = categoryService.getAllCategory();
        return list.size();
    }

    @Override
    public int getAmountProducts() {
        List<ProductDto> list = productService.getAllProduct();
        return list.size() ;
    }

    @Override
    public int getAmountOrder() {
        List<OrderDetailDto> list = orderService.getAllOrder();
        return list.size();
    }


}
