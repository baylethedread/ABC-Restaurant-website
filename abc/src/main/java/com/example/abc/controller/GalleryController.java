package com.example.abc.controller;

import com.example.abc.model.Product;
import com.example.abc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private ProductRepository productRepository;

    // Method to view the gallery with all products
    @GetMapping
    public String viewGallery(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "gallery";
    }

    // Method to handle product search
    @GetMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(query);
        model.addAttribute("products", products);
        return "gallery";
    }
}
