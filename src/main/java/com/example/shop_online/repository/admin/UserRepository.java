package com.example.shop_online.repository.admin;

import com.example.shop_online.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query("SELECT u FROM users u WHERE u.email = ?1")
    public UserEntity findByEmail(String email);

    public UserEntity findByResetPasswordToken(String token);
}
