package com.example.shop_online.service.admin;

import com.example.shop_online.dto.*;
import com.example.shop_online.entity.ProductEntity;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getAllProduct();
    ProductById getProductById(int id);

    ResponseEntity<ResponseData> createProduct(MultipartFile file, ProductEntity product) throws IOException;

    ResponseEntity<ResponseData> deleteProductById(int id);

    ResponseEntity<ResponseData> updateByProductById(int id, ProductEntity product,MultipartFile file) throws IOException;

    ResponseEntity<ResponseData> updateProduct(int id, ProductEntity product);

    List<ProductHomeDto> getNewProduct();

    List<ProductHomeDto> getDiscountProduct();

    List<ProductHomeDto> getSpecialProduct();

    List<ProductHomeDto> getViewProduct();

    List<ProductSellingDto> getSellingProduct();

    List<ProductHomeDto> getAllHomeProduct();

    ProductDetail getProductDetail(int id);


    List<ProductHomeDto> getSeachProduct(String strSeach);


}
