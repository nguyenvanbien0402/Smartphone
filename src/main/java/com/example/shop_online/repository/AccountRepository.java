package com.example.shop_online.repository;

import com.example.shop_online.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<UserEntity,Integer> {
    Boolean existsByEmail(String email);
    UserEntity findByEmail(String email);

    UserEntity findById(int id);

    @Override
    <S extends UserEntity> S save(S entity);
}
