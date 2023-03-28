package com.example.shop_online.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailService {

    UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

}
