package com.example.shop_online.service.admin;

import com.example.shop_online.config.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService{

    private Path rootPath;
    @Autowired
    public FileServiceImpl(FileStorageProperties fileStorageProperties) throws IOException {
        this.rootPath = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        if (Files.notExists(this.rootPath)) {
            Files.createDirectories(rootPath);
        }
    }


    @Override
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), rootPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (Exception e) {
            System.out.println("lỗi save file " + e.getMessage());
            return fileName;
        }

    }
}
