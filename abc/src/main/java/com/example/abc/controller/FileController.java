package com.example.abc.controller;

import com.example.abc.model.Product;
import com.example.abc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final String UPLOAD_DIR = "src/images/";

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public ResponseEntity<Resource> serveFile(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null && product.getImagePath() != null) {
            File file = new File(product.getImagePath());
            if (file.exists()) {
                Resource fileResource = new FileSystemResource(file);
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                        .contentType(MediaType.IMAGE_JPEG) // Adjust if needed
                        .body(fileResource);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
