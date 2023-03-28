package com.example.shop_online.service.admin;

import com.example.shop_online.dto.ProductHomeDto;
import com.example.shop_online.entity.CategoryEntity;
import com.example.shop_online.entity.ProductEntity;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.CategoryRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepositoty categoryRepositoty;
    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryRepositoty.findAll();
    }

    @Override
    public List<CategoryEntity> getAllHomeCategory() {
        return categoryRepositoty.findAll();
    }

    @Override
    public Optional<CategoryEntity> getCategoryById(int id) {
        return categoryRepositoty.findById(id);
    }

    @Override
    public ResponseEntity<ResponseData> creatCategory(CategoryEntity categoryEntity) {
        CategoryEntity category = categoryRepositoty.save(categoryEntity);
        ResponseData responseData = null;
        if (category != null) {
           responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"create suscessfully",category);
        }
           return  new ResponseEntity<>(responseData,HttpStatus.OK);


    }

    @Override
    public ResponseEntity<ResponseData> deleteCategory(int id) {
       Optional<CategoryEntity> category =  categoryRepositoty.findById(id);
       ResponseData responseData =null ;
       if (category!=null)
       {
           categoryRepositoty.deleteById(id);
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"delete suscessfully",null);
       }
       else  {
           responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,"faild",null);
       }

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public List<ProductHomeDto> getProductByTypeid(int id) {
        CategoryEntity category = categoryRepositoty.findById(id).get();
        List<ProductEntity> homeDtoList = category.getProducList();
        List<ProductHomeDto> productHomeDtos = new ArrayList<>();
        for (ProductEntity data: homeDtoList
             ) {
            ProductHomeDto productHomeDto = new ProductHomeDto();
            productHomeDto.setId(data.getId());
            productHomeDto.setPhoto(data.getPhoto());
            productHomeDto.setName(data.getName());
            productHomeDto.setDiscout(data.getDiscount());
            productHomeDto.setPrice(data.getPrice());
            productHomeDto.setViewCount(data.getViewCount());
            productHomeDtos.add(productHomeDto);

        }
        return productHomeDtos;
    }

    @Override
    public ResponseEntity<ResponseData> updateCategory(int id, CategoryEntity category) {
        ResponseData responseData = null;
        CategoryEntity cate = categoryRepositoty.findById(id).get();
        if (cate!=null) {
                 cate.setName(category.getName());
                 cate.setNameVn(category.getNameVn());
                 categoryRepositoty.save(cate);
                 responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"update susscesfully",cate);
        } else {
            responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,"cant not update", null);
        }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }


}
