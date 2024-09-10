package com.example.abc.controller;

import com.example.abc.model.Category;
import com.example.abc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category") // Updated to match the form's action URL
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add-category")
    public String addCategory(@RequestParam("name") String categoryName, Model model) {
        Category category = new Category();
        category.setName(categoryName);
        categoryRepository.save(category);

        // Fetch updated categories to display on the admin dashboard
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "admin-dashboard"; // Return to the dashboard to refresh the page
    }

    @GetMapping
    public String getAdminDashboard(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin-dashboard"; // Thymeleaf template name
    }
}
