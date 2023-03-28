package com.example.shop_online.service.admin;

import com.example.shop_online.dto.CommentDto;
import com.example.shop_online.entity.CommentEntity;
import com.example.shop_online.entity.ProductEntity;
import com.example.shop_online.payload.request.CommentRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.CommentRepository;
import com.example.shop_online.repository.admin.ProductRepository;
import com.example.shop_online.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<CommentDto> getCommentByProductId(int id) {
        ProductEntity product = productRepository.findById(id).get();
        List<CommentEntity> commentEntityList = product.getCommentEntities();
        List<CommentDto> commentDtos = new ArrayList<>();
        for (CommentEntity data: commentEntityList
             ) {
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentId(data.getId());
            commentDto.setContent(data.getContent());
            commentDto.setStar(data.getStar());
            commentDto.setCreateDate(data.getCreateDate());
            commentDto.setUserName(data.getUser().getFullname());
            commentDto.setUserPhoto(data.getUser().getPhoto());
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }

    @Override
    public ResponseEntity<ResponseData> insertComment(CommentRequest commentRequest) {
         CommentEntity commentEntity = new CommentEntity();
         commentEntity.setContent(commentRequest.getContent());
         commentEntity.setStar(commentRequest.getStar());
         commentEntity.setCreateDate(commentRequest.getCreateDate());
         commentEntity.setUser(userRepository.findById(commentRequest.getUserId()).get());
         commentEntity.setProduct(productRepository.findById(commentRequest.getProductId()).get());
          commentRepository.save(commentEntity);
         ResponseData responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"",null);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
