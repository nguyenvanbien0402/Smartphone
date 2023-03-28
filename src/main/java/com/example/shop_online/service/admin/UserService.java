package com.example.shop_online.service.admin;

import com.example.shop_online.dto.UserDto;
import com.example.shop_online.dto.UserOderDto;
import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.payload.request.UserInfo;
import com.example.shop_online.payload.request.UserRequest;
import com.example.shop_online.payload.response.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getAllUser();
    Optional<UserEntity> findUserById(int id);
    ResponseEntity<ResponseData> createAccount(UserEntity userEntity);

    ResponseEntity<ResponseData> deleteAccount(int id);

    ResponseEntity<ResponseData> updateAccountById(UserEntity user, int id);


      List<UserOderDto> getUserOder(int id);


      ResponseEntity<ResponseData> updateInfoUser(MultipartFile file, UserInfo userInfo,int id) throws IOException;


         boolean   updateResetPasswordToken(String token, String email);
         UserEntity  getByResetPasswordToken(String token);
         void updatePassword(UserEntity user,String newPassword);

         boolean changePass(int userId, String newpass);

}
