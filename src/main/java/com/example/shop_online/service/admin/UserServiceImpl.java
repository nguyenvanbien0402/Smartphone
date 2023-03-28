package com.example.shop_online.service.admin;


import com.example.shop_online.dto.UserDto;
import com.example.shop_online.dto.UserOderDto;
import com.example.shop_online.entity.OrderDetailEntity;
import com.example.shop_online.entity.OrderEntity;
import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.model.UserOder;
import com.example.shop_online.payload.request.UserInfo;
import com.example.shop_online.payload.request.UserRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.AccountRepository;
import com.example.shop_online.repository.admin.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> list = userRepository.findAll();
       List<UserDto> listUserDto = new ArrayList<>();
        for (UserEntity data: list
             ) {
            UserDto userDto = new UserDto();
            userDto.setFullname(data.getFullname());
            userDto.setEmail(data.getEmail());
            userDto.setPhone(data.getPhone());
            userDto.setId(data.getId());
            userDto.setAdmin(data.isAdmin());
            userDto.setActivated(data.isActivated());
            listUserDto.add(userDto);
        }
        return listUserDto;
    }

    @Override
    public Optional<UserEntity> findUserById(int id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user;
    }

    @Override
    public ResponseEntity<ResponseData> createAccount( UserEntity userEntity) {
        UserEntity existUser = accountRepository.findByEmail(userEntity.getEmail());
        ResponseData responseData;
        if (existUser==null) {
          String pass =   passwordEncoder.encode(userEntity.getPassword());
          userEntity.setPassword(pass);
            UserEntity user= userRepository.save(userEntity);
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"create user successfully",user);
        }
        else {
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.FALSE,"create user faild","");
        }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> deleteAccount(int id) {
        Optional<UserEntity> user = userRepository.findById(id);

        ResponseData responseData;
        if (user!=null) {
            userRepository.deleteById(id);
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"delete user successfully",user);
        } else {
            responseData = new ResponseData(HttpStatus.OK.value(), Boolean.FALSE,"delete user faild",user);
        }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> updateAccountById(UserEntity user, int id) {
        UserEntity userEntity = userRepository.findById(id).get();
        if (userEntity!=null) {
            userEntity.setFullname(user.getFullname());
            userEntity.setEmail(user.getEmail());
            userEntity.setAdmin(user.isAdmin());
            userEntity.setPassword(user.getPassword());
            userEntity.setActivated(user.isActivated());
            userEntity.setPhone(user.getPhone());
            userRepository.save(userEntity);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,
                    "update Account sucessfully", ""),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,
                    "update Account faild",null),HttpStatus.OK);
        }

    }

    @Override
    public List<UserOderDto> getUserOder(int id) {
        UserEntity user = userRepository.findById(id).get();
        List<OrderEntity> orderEntityList = user.getOrders();
       List<UserOderDto> oderDtos = new ArrayList<>();
        for (OrderEntity data: orderEntityList
             ) {
            UserOderDto userOderDto = new UserOderDto();
            userOderDto.setAddress(data.getAddress());
            userOderDto.setAmount(data.getAmount());
            userOderDto.setOrderId(data.getId());
            userOderDto.setStatus(data.getStatus());
            userOderDto.setPhone(data.getPhone());
            userOderDto.setDescription(data.getDescription());
            userOderDto.setOrderDate(data.getOrderDate());
            List<OrderDetailEntity> orderDetailEntities = data.getOrderDetails();
            List<UserOder> userOders = new ArrayList<>();
            for (OrderDetailEntity dt: orderDetailEntities
                 ) {
                UserOder userOder = new UserOder();
                userOder.setQuantity(dt.getQuantity());
                userOder.setProductName(dt.getProduct().getName());
                userOder.setUnitPrice(dt.getUnitPrice());
                userOder.setDiscout(dt.getDiscount());
                userOder.setPhoto(dt.getProduct().getPhoto());
                userOders.add(userOder);
            }
            userOderDto.setListProducts(userOders);
            oderDtos.add(userOderDto);
        }
        return oderDtos;
    }
    private String path = "C:\\Users\\USER\\OneDrive\\Desktop\\doan\\spring-vuejs - Copy\\src\\assets\\images";

    @Override
    public ResponseEntity<ResponseData> updateInfoUser(MultipartFile file, UserInfo userInfo, int id) throws IOException {
        String filePath = path + "/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        UserEntity user = userRepository.findById(id).get();
        user.setPhone(userInfo.getPhone());
        user.setEmail(userInfo.getEmail());
        user.setFullname(userInfo.getFullname());
        user.setPhoto(file.getOriginalFilename());
        userRepository.save(user);
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(),Boolean.TRUE,"cập nhật thông tin thành công", null   );


        return new ResponseEntity<>(responseData,HttpStatus.OK) ;
    }



//reset password feature
    @Override
    public boolean updateResetPasswordToken(String token, String email) {
        boolean ok ;
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
            ok = true;
        } else {
         ok =false;
        }
        return ok;
    }

    @Override
    public UserEntity getByResetPasswordToken(String token) {
    return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(UserEntity user, String newPassword) {

        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

    @Override
    public boolean changePass(int userId, String newpass) {
        UserEntity user = userRepository.findById(userId).get();
        boolean exist;
      if(user != null) {
          user.setPassword(newpass);
          userRepository.save(user);
          exist = true;
      } else {
          exist = false;
      }
        return exist;
    }


}
