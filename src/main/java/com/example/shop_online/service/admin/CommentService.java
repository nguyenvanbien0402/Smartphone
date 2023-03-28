package com.example.shop_online.service.admin;

import com.example.shop_online.dto.CommentDto;
import com.example.shop_online.entity.CommentEntity;
import com.example.shop_online.payload.request.CommentRequest;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {

    List<CommentDto> getCommentByProductId(int id);


    ResponseEntity<ResponseData> insertComment(CommentRequest commentRequest);
}
