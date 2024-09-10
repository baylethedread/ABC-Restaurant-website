package com.example.abc.controller;

import com.example.abc.model.Category;
import com.example.abc.model.Product;
import com.example.abc.repository.CategoryRepository;
import com.example.abc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private static final String UPLOAD_DIR = "src/images/";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add-product")
    public String addProduct(@RequestParam("name") String productName,
                             @RequestParam("category") Long categoryId,
                             @RequestParam("price") Double productPrice,
                             @RequestParam("description") String productDescription,
                             @RequestParam("image") MultipartFile imageFile,
                             Model model) throws IOException {

        Product product = new Product();
        product.setName(productName);
        product.setCategory(categoryRepository.findById(categoryId).orElse(null));
        product.setPrice(productPrice);
        product.setDescription(productDescription);

        if (!imageFile.isEmpty()) {
            // Save image file to the directory
            String imagePath = UPLOAD_DIR + imageFile.getOriginalFilename();
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Create the directory if it doesn't exist
            }
            Path path = Paths.get(imagePath);
            Files.write(path, imageFile.getBytes());
            product.setImagePath(imagePath);
        }

        productRepository.save(product);

        // Fetch updated products and categories to display on the admin dashboard
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);

        return "admin-dashboard";
    }

    @GetMapping
    public String getAdminDashboard(Model model) {
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "admin-dashboard";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productRepository.deleteById(id);  // Delete product by ID

        // After deletion, fetch updated product list
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "redirect:/admin/product";
    }
}
