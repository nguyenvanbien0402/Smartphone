package com.example.shop_online.admincontroller;


import com.example.shop_online.dto.ProductDto;
import com.example.shop_online.dto.ProductHomeDto;
import com.example.shop_online.entity.ProductEntity;
import com.example.shop_online.payload.request.ProductRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.service.admin.CategoryService;
import com.example.shop_online.service.admin.FileService;
import com.example.shop_online.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    FileService fileService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ServletContext app;

    @GetMapping("/all-product")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById (@PathVariable(name = "id") int id) {
        ResponseData responseData = new ResponseData();

        if (productService.getProductById(id)!=null) {
            responseData.setData(productService.getProductById(id));
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

    @GetMapping("/product/detail/{id}")
    public ResponseEntity<?> getProductDetail (@PathVariable(name = "id") int id) {
        ResponseData responseData = new ResponseData();

        if (productService.getProductDetail(id)!=null) {
            responseData.setData(productService.getProductDetail(id));
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

    @PostMapping(value = "/create-product", headers = "content-type=multipart/form-data")
    public ResponseEntity<?> createProduct(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "price") float price,
            @RequestParam(name = "available") boolean available,
            @RequestParam(name = "quantity") int quantity,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "viewCount") int viewCount,
            @RequestParam(name = "discount") float discount,
            @RequestParam(name = "special") boolean special,
            @RequestParam(name = "categoryId") int categoryId,
            @RequestParam(name = "photo") MultipartFile file) throws IOException, ParseException {

        ProductEntity product = new ProductEntity();
        Date date = new Date();
        product.setName(name);
        product.setQuantity(quantity);
        product.setViewCount(viewCount);
        product.setCreateDate(date);
        product.setSpecial(special);
        product.setAvailable(available);
        product.setPrice(price);
        product.setDescription(description);
        product.setDiscount(discount);
        System.out.println(date);
        product.setCategory(categoryService.getCategoryById(categoryId).get());
       return   productService.createProduct(file, product);
    }


        @DeleteMapping("delete-product/{id}")
        public ResponseEntity<?> deleteProductById(@PathVariable(name = "id") int id) {
            return productService.deleteProductById(id);
        }


        @PutMapping("/update-product/{id}")
        public ResponseEntity<?> updateProductById(
                @PathVariable int id,
                @RequestParam(name = "name") String name,
                @RequestParam(name = "price") float price,
                @RequestParam(name = "available") boolean available,
                @RequestParam(name = "quantity") int quantity,
                @RequestParam(name = "description") String description,
                @RequestParam(name = "viewCount") int viewCount,
                @RequestParam(name = "discount") float discount,
                @RequestParam(name = "special") boolean special,
                @RequestParam(name = "categoryId") int categoryId,
                @RequestParam(name = "photo") MultipartFile file) throws IOException, ParseException {


            ProductEntity product = new ProductEntity();
            product.setPhoto(file.getOriginalFilename());
            product.setName(name);
            product.setQuantity(quantity);
            product.setViewCount(viewCount);
            product.setSpecial(special);
            product.setAvailable(available);
            product.setPrice(price);
            product.setDescription(description);
            product.setDiscount(discount);
            product.setCategory(categoryService.getCategoryById(categoryId).get());
            return productService.updateByProductById(id,product,file);

        }


    @PutMapping("/update-pro/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "price") float price,
            @RequestParam(name = "available") boolean available,
            @RequestParam(name = "quantity") int quantity,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "viewCount") int viewCount,
            @RequestParam(name = "discount") float discount,
            @RequestParam(name = "special") boolean special,
            @RequestParam(name = "categoryId") int categoryId,
            @RequestParam(name = "photo") String photo) throws IOException, ParseException {

        ProductEntity product = new ProductEntity();
        product.setPhoto(photo);
        product.setName(name);
        product.setQuantity(quantity);
        product.setViewCount(viewCount);
        product.setSpecial(special);
        product.setAvailable(available);
        product.setPrice(price);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setCategory(categoryService.getCategoryById(categoryId).get());
        return productService.updateProduct(id,product);

    }
        @PostMapping("/seach-product")
    public List<ProductHomeDto> getSeachProduct(@RequestParam(name = "strSeach") String strSeach)
        {
            return productService.getSeachProduct(strSeach);
        }

}
