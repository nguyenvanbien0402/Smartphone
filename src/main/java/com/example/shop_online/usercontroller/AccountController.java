package com.example.shop_online.usercontroller;


import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.jwt.JwtTokenHelper;
import com.example.shop_online.payload.request.SinginRequest;
import com.example.shop_online.payload.request.SingupRequest;
import com.example.shop_online.payload.response.DataTokenResponse;
import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.AccountRepository;
import com.example.shop_online.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("")
@CrossOrigin
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AcountService acountService;
    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/signup")
   public ResponseEntity<?> singUp(@RequestBody SingupRequest singupRequest) {
        ResponseData responseData = new ResponseData();
        boolean existingEmail = acountService.checkExistingEmail(singupRequest.getEmail());
        if (existingEmail) {
           responseData.setStatus(HttpStatus.OK.value());
           responseData.setSuccess(false);
           responseData.setData("");
           responseData.setDesc("Email đã tồn tại");
        } else {

            UserEntity user = new UserEntity();
            user.setFullname(singupRequest.getFullname());
            user.setEmail(singupRequest.getEmail());
            user.setPassword(passwordEncoder.encode(singupRequest.getPassword()));
            user.setActivated(singupRequest.isActivated());
            user.setAdmin(singupRequest.isAdmin());

            UserEntity result =  accountRepository.save(user);
            responseData.setStatus(HttpStatus.OK.value());
            responseData.setSuccess(true);
            responseData.setData(result);
            responseData.setDesc("Đăng ký tài khoản thành công ");
        }
        return new  ResponseEntity<>(responseData,HttpStatus.OK);
   }

   @PostMapping("/signin")
   public ResponseEntity<?> signin(@RequestBody SinginRequest singinRequest) {

       Authentication authentication =   authenticationManager.authenticate(
       new UsernamePasswordAuthenticationToken(singinRequest.getEmail(), singinRequest.getPassword(),new ArrayList<>()));
       SecurityContextHolder.getContext().setAuthentication(authentication);
       String jwt = jwtTokenHelper.generateJwtToken(singinRequest.getEmail());

       DataTokenResponse dataTokenResponse = new DataTokenResponse();
       dataTokenResponse.setToken(jwt);
       dataTokenResponse.setAdmin(accountRepository.findByEmail(singinRequest.getEmail()).isAdmin());
       dataTokenResponse.setName(accountRepository.findByEmail(singinRequest.getEmail()).getFullname());
       dataTokenResponse.setId(accountRepository.findByEmail(singinRequest.getEmail()).getId());
       dataTokenResponse.setPhoto(accountRepository.findByEmail(singinRequest.getEmail()).getPhoto());
       ResponseData responseData = new ResponseData();
       responseData.setData(dataTokenResponse);
       responseData.setStatus(HttpStatus.OK.value());
       responseData.setDesc("Đăng nhập thành công");
       responseData.setSuccess(true);
       return new ResponseEntity<>(responseData,HttpStatus.OK);
   }
}
