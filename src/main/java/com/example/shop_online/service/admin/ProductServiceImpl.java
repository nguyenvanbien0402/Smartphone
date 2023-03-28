package com.example.shop_online.service.admin;


import com.example.shop_online.dto.*;
import com.example.shop_online.entity.OrderDetailEntity;
import com.example.shop_online.entity.ProductEntity;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

        @Autowired
        ProductRepository productRepository;
        @Autowired
        CategoryService categoryService;

//       private String folder_path = "C:\\Users\\USER\\OneDrive\\Desktop\\doan\\shop_online\\src\\main\\resources\\static";
       private String path = "C:\\Users\\USER\\OneDrive\\Desktop\\doan\\spring-vue\\src\\assets\\images";
        @Override
        public List<ProductDto> getAllProduct() {
            List<ProductEntity> productEntities = productRepository.findAll();
            List<ProductDto> productDtos = new ArrayList<>();
            for (ProductEntity data: productEntities
                 ) {
                ProductDto productDto = new ProductDto();
                productDto.setPhoto(data.getPhoto());
                productDto.setId(data.getId());
                productDto.setName(data.getName());
                productDto.setQuantity(data.getQuantity());
                productDto.setPrice(data.getPrice());
                productDto.setDiscout(data.getDiscount());
                productDto.setViewCount(data.getViewCount());
                productDto.setType(data.getCategory().getNameVn());
                productDtos.add(productDto);
            }
            return productDtos;
        }

    @Override
    public ProductById getProductById(int id) {

                ProductEntity productEntities = productRepository.findById(id).get();
                ProductById productById = new ProductById();

                productById.setId(productEntities.getId());
                productById.setName(productEntities.getName());
                productById.setAvailable(productEntities.isAvailable());
                productById.setDescription(productEntities.getDescription());
                productById.setDiscout(productEntities.getDiscount());
                productById.setCreateDate(productEntities.getCreateDate());
                productById.setType(productEntities.getCategory().getName() + productEntities.getCategory().getNameVn());
                productById.setSpecial(productEntities.isSpecial());
                productById.setQuantity(productEntities.getQuantity());
                productById.setPrice(productEntities.getPrice());
                productById.setPhoto(productEntities.getPhoto());
                productById.setViewCount(productEntities.getViewCount());
                productById.setCategoryId(productEntities.getCategory().getId());
        return productById;
        }




    @Override
        public ResponseEntity<ResponseData> createProduct(MultipartFile file,ProductEntity pro) throws IOException {
          String filePath = path + "/" + file.getOriginalFilename();
          pro.setPhoto(file.getOriginalFilename());
          file.transferTo(new File(filePath));
          ProductEntity pr =  productRepository.save(pro);
          ResponseData responseData = null;
          if (pr!=null) {
              responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"creat product suscessfully",pro);
          } else
          {
              responseData = new ResponseData((HttpStatus.NO_CONTENT.value()),Boolean.FALSE,"creat product faild",null);
          }
          return new ResponseEntity<>(responseData, HttpStatus.OK);
        }



    @Override
    public ResponseEntity<ResponseData> deleteProductById(int id) {
        Optional<ProductEntity> product = productRepository.findById(id);

        ResponseData responseData ;
        if (product!=null) {
            productRepository.deleteById(id);
            responseData = new  ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"delete product sussecfully",null);
        }  else
        {
            responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,"delete priduct fail",null);
        }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> updateByProductById(int id,  ProductEntity product,MultipartFile file) throws IOException {
            ResponseData responseData;
        String filePath = path + "/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));

           ProductEntity pr = productRepository.findById(id).get();
           if (pr!=null) {
              pr.setId(id);
              pr.setName(product.getName());
              pr.setPrice(product.getPrice());
              pr.setSpecial(product.isSpecial());
              pr.setAvailable(product.isAvailable());
              pr.setDescription(product.getDescription());
              pr.setViewCount(product.getViewCount());
              pr.setCategory(pr.getCategory());
              pr.setDiscount(product.getDiscount());
              pr.setPhoto(product.getPhoto());
              pr.setQuantity(product.getQuantity());
              productRepository.save(pr);
               responseData  = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"update product successfully",null);
           }else {
               responseData  = new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,"update product faild", null);
           }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> updateProduct(int id, ProductEntity product) {
            ResponseData responseData;
            Optional<ProductEntity> pr = productRepository.findById(id);
            if ((pr.isPresent())) {
                pr.get().setId(id);
                pr.get().setName(product.getName());
                pr.get().setPrice(product.getPrice());
                pr.get().setSpecial(product.isSpecial());
                pr.get().setAvailable(product.isAvailable());
                pr.get().setDescription(product.getDescription());
                pr.get().setViewCount(product.getViewCount());
                pr.get().setCategory(product.getCategory());
                pr.get().setDiscount(product.getDiscount());
                pr.get().setPhoto(product.getPhoto());
                pr.get().setQuantity(product.getQuantity());
                pr.ifPresent(productRepository::save);
                responseData  = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"update product successfully",null);
            }else {
                responseData  = new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,"update product faild", null);
            }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }


    @Override
    public List<ProductHomeDto> getNewProduct() {
            List<ProductEntity> productEntityList= productRepository.getNewProduct();
            List<ProductHomeDto> productHomeDtos = new ArrayList<>();
        for (ProductEntity data: productEntityList
             ) {
            ProductHomeDto productHomeDto = new ProductHomeDto();
            productHomeDto.setName(data.getName());
            productHomeDto.setPhoto(data.getPhoto());
            productHomeDto.setDiscout(data.getDiscount());
            productHomeDto.setViewCount(data.getViewCount());
            productHomeDto.setId(data.getId());
            productHomeDto.setPrice(data.getPrice());
            productHomeDtos.add(productHomeDto);
        }
        return productHomeDtos;
    }

    @Override
    public List<ProductHomeDto> getDiscountProduct() {
            List<ProductEntity> list = productRepository.getDiscountProduct();
            List<ProductHomeDto> homeDtoList = new ArrayList<>();
        for (ProductEntity data:list
             ) {
            ProductHomeDto productHomeDto = new ProductHomeDto();
            productHomeDto.setName(data.getName());
            productHomeDto.setPrice(data.getPrice());
            productHomeDto.setPhoto(data.getPhoto());
            productHomeDto.setDiscout(data.getDiscount());
            productHomeDto.setViewCount(data.getViewCount());
            productHomeDto.setId(data.getId());
            homeDtoList.add(productHomeDto);
        }
        return homeDtoList ;
    }

    @Override
    public List<ProductHomeDto> getSpecialProduct() {
            List<ProductEntity> list = productRepository.getSpecialProduct();
            List<ProductHomeDto> homeDtoList = new ArrayList<>();
        for (ProductEntity data: list
             ) {
            ProductHomeDto productHomeDto = new ProductHomeDto();
            productHomeDto.setName(data.getName());
            productHomeDto.setPrice(data.getPrice());
            productHomeDto.setDiscout(data.getDiscount());
            productHomeDto.setPhoto(data.getPhoto());
            productHomeDto.setId(data.getId());
            productHomeDto.setViewCount(data.getViewCount());
            homeDtoList.add(productHomeDto);
        }
        return homeDtoList;
    }

    @Override
    public List<ProductHomeDto> getViewProduct() {
        List<ProductEntity> list = productRepository.getViewProduct();
        List<ProductHomeDto> homeDtoList = new ArrayList<>();
        for (ProductEntity data: list
        ) {
            ProductHomeDto productHomeDto = new ProductHomeDto();
            productHomeDto.setName(data.getName());
            productHomeDto.setPrice(data.getPrice());
            productHomeDto.setDiscout(data.getDiscount());
            productHomeDto.setPhoto(data.getPhoto());
            productHomeDto.setId(data.getId());
            productHomeDto.setViewCount(data.getViewCount());
            homeDtoList.add(productHomeDto);

        }
        return homeDtoList;
    }

    @Override
    public List<ProductSellingDto> getSellingProduct() {

            List<ProductEntity> list  = productRepository.getSellingProduct();
            List<ProductSellingDto> sellingDtos = new ArrayList<>();
        for (ProductEntity data: list
             ) {
            ProductSellingDto productSellingDto = new ProductSellingDto();
            productSellingDto.setName(data.getName());
            productSellingDto.setDiscout(data.getDiscount());
            productSellingDto.setViewCount(data.getViewCount());
            productSellingDto.setId(data.getId());
            productSellingDto.setPhoto(data.getPhoto());
            productSellingDto.setPrice(data.getPrice());
            List<OrderDetailEntity> orderDetailEntities = data.getOrderDetailEntities();
            int amountSelling = orderDetailEntities.size();
            productSellingDto.setAmountOrder(amountSelling);
            sellingDtos.add(productSellingDto);
        }
         return sellingDtos;
    }

    @Override
    public List<ProductHomeDto> getAllHomeProduct() {
            List<ProductEntity> list = productRepository.findAll();
            List<ProductHomeDto> homeDtoList = new ArrayList<>();
        for (ProductEntity data: list
             ) {
               ProductHomeDto productHomeDto = new ProductHomeDto();
               productHomeDto.setId(data.getId());
               productHomeDto.setName(data.getName());
               productHomeDto.setPrice(data.getPrice());
               productHomeDto.setDiscout(data.getDiscount());
               productHomeDto.setViewCount(data.getViewCount());
               productHomeDto.setPhoto(data.getPhoto());
               homeDtoList.add(productHomeDto);
        }
        return homeDtoList;
    }

    @Override
    public ProductDetail getProductDetail(int id) {

        ProductEntity productEntities = productRepository.findById(id).get();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(productEntities.getId());
        productDetail.setName(productEntities.getName());
        productDetail.setDescription(productEntities.getDescription());
        productDetail.setDiscout(productEntities.getDiscount());
        productDetail.setPrice(productEntities.getPrice());
        productDetail.setPhoto(productEntities.getPhoto());
        productDetail.setViewCount(productEntities.getViewCount());
        return productDetail;

    }

    @Override
    public List<ProductHomeDto> getSeachProduct(String strSeach) {
            List<ProductEntity> list = productRepository.getSeachProduct(strSeach);
            List<ProductHomeDto> homeDtoList  = new ArrayList<>();
        for ( ProductEntity data: list
             ) {
            ProductHomeDto productHomeDto = new ProductHomeDto();
            productHomeDto.setName(data.getName());
            productHomeDto.setPhoto(data.getPhoto());
            productHomeDto.setPrice(data.getPrice());
            productHomeDto.setDiscout(data.getDiscount());
            productHomeDto.setId(data.getId());
            productHomeDto.setViewCount(data.getViewCount());
            homeDtoList.add(productHomeDto);
        }
        return homeDtoList;
    }


}
