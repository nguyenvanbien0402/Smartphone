package com.example.shop_online.usercontroller;


import com.example.shop_online.dto.CommentDto;
import com.example.shop_online.entity.CommentEntity;
import com.example.shop_online.payload.request.CommentRequest;
import com.example.shop_online.service.admin.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment-by-productId/{id}")
    public List<CommentDto> getCommentByProductId(@PathVariable(name = "id") int id)
    {
        return commentService.getCommentByProductId(id);
    }

    @PostMapping("/insert-comment")
    public ResponseEntity<?> insertCommnet(@RequestBody CommentRequest commentRequest)
    {
        return  commentService.insertComment(commentRequest);
    }

}
