package com.example.shop_online.admincontroller;

import com.example.shop_online.dto.CategoryDto;
import com.example.shop_online.dto.ProductHomeDto;
import com.example.shop_online.entity.CategoryEntity;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.service.admin.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        ResponseData responseData = new ResponseData();
        List<CategoryEntity> cateList = categoryService.getAllCategory();
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

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategoryById (@PathVariable(name = "id") int id) {
        ResponseData responseData = new ResponseData();

        if (categoryService.getCategoryById(id).isPresent()) {
            responseData.setData(categoryService.getCategoryById(id));
            responseData.setDesc("");
            responseData.setStatus(HttpStatus.OK.value());
            responseData.setSuccess(true);
        } else {
           responseData.setSuccess(false);
           responseData.setData("");
           responseData.setDesc("Lỗi ");
        }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(@Validated @RequestBody CategoryEntity categoryEntity) {
       return categoryService.creatCategory(categoryEntity);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable(name = "id") int id) {
            return categoryService.deleteCategory(id);
    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable(name = "id") int id, @RequestBody CategoryEntity category) {
         return categoryService.updateCategory(id, category);
    }


    @GetMapping("/pro-by-type/{id}")
    public ResponseEntity<?> getProByType(@PathVariable(name = "id") int id) {
        List<ProductHomeDto>  list = categoryService.getProductByTypeid(id);
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",list);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
