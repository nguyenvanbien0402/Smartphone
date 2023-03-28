package com.example.shop_online.service.admin;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

       String storeFile(MultipartFile file);
}
