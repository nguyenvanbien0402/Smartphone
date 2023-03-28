package com.example.shop_online.admincontroller;


import com.example.shop_online.dto.UserDto;
import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.payload.request.UserInfo;
import com.example.shop_online.payload.request.UserRequest;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/all-account")
    public ResponseEntity<?> getAllUser() {
        ResponseData responseData;
      List<UserDto> listUser = userService.getAllUser();
        if (listUser.size()>0) {
          responseData = new ResponseData(HttpStatus.OK.value(),
                    Boolean.TRUE,"",listUser);
        }else {
          responseData = new ResponseData(HttpStatus.OK.value(),
                    Boolean.TRUE,"Not found any User",listUser);
        }
      return new ResponseEntity<>(responseData,HttpStatus.OK);
    }


    @PostMapping("/create-account")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        return userService.createAccount(user);
    }


    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") int id) {
        return userService.deleteAccount(id);
    }


    @GetMapping("/account/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable int id) {
        Optional<UserEntity> user =    userService.findUserById(id);
        if (user.isPresent()) {
            UserDto  userDto = new UserDto();
            userDto.setFullname(user.get().getFullname());
            userDto.setPhone(user.get().getPhone());
            userDto.setEmail(user.get().getEmail());
            userDto.setId(user.get().getId());
            userDto.setPhoto(user.get().getPhoto());
            userDto.setAdmin(user.get().isAdmin());
            userDto.setActivated(user.get().isActivated());
            userDto.setPassword(user.get().getPassword());
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), Boolean.TRUE,"find account successfully",userDto),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseData(HttpStatus.NOT_FOUND.value(), Boolean.FALSE,"Canot find account ",null),HttpStatus.OK);
        }
    }

        @PutMapping("/update-account/{id}")
        public ResponseEntity<ResponseData> updateAccount(@PathVariable(name = "id") int id, @RequestBody UserEntity user) {
           return userService.updateAccountById(user, id);
        }


        @PutMapping("/update-info-user/{userId}")
    public  ResponseEntity<ResponseData> updateInfoUser(@PathVariable(name = "userId") int id,
                                                        @RequestParam(name = "fullname") String fullname,
                                                        @RequestParam(name = "phone") String phone,
                                                        @RequestParam(name = "email") String email,
                                                         @RequestParam(name = "photo") MultipartFile file ) throws IOException {
         UserInfo userInfo = new UserInfo();
         userInfo.setEmail(email);
         userInfo.setFullname(fullname);
         userInfo.setPhone(phone);
         return userService.updateInfoUser(file,userInfo,id);


        }
}
