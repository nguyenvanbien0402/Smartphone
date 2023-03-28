package com.example.shop_online.service.impl;


import com.example.shop_online.entity.UserEntity;
import com.example.shop_online.repository.AccountRepository;
import com.example.shop_online.security.CustomUserDetails;
import com.example.shop_online.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailServiceImpl implements CustomUserDetailService, UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        UserEntity user = accountRepository.findByEmail(usernameOrEmail);
        System.out.println("kiem tra email" + user.getPassword());
        if(user==null){
            throw new UsernameNotFoundException("User " + usernameOrEmail + " was not found in the database");
        }
       return new CustomUserDetails(user);
    }
}
