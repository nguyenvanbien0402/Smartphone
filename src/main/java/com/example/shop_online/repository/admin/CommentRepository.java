package com.example.shop_online.repository.admin;

import com.example.shop_online.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {

}
