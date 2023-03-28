package com.example.shop_online.service.impl;


import com.example.shop_online.repository.AccountRepository;
import com.example.shop_online.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl  implements AcountService {

    @Autowired
    AccountRepository accountRepository;
    @Override
    public boolean checkExistingEmail(String email) {
        return accountRepository.existsByEmail(email);
    }
}
