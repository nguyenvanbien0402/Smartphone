package com.example.shop_online.service.admin;

import com.example.shop_online.dto.ProductHomeDto;
import com.example.shop_online.entity.CategoryEntity;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryEntity> getAllCategory();

    List<CategoryEntity> getAllHomeCategory();
    Optional<CategoryEntity> getCategoryById(int id);

    ResponseEntity<ResponseData> creatCategory(CategoryEntity categoryEntity);

    ResponseEntity<ResponseData> deleteCategory(int id);

    List<ProductHomeDto> getProductByTypeid(int id);




    ResponseEntity<ResponseData> updateCategory(int id, CategoryEntity category);
}
