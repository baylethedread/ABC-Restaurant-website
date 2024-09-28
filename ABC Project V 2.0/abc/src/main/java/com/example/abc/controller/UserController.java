package com.example.abc.controller;

import com.example.abc.model.User;
import com.example.abc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Handle registration form
    @GetMapping("/register")
    public String showRegistrationForm(@RequestParam(value = "success", required = false) String success, Model model) {
        model.addAttribute("user", new User());
        if ("true".equals(success)) {
            model.addAttribute("message", "Registration successful! You can log in.");
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setUsertype("customer"); // Set the usertype to "customer"
        userRepository.save(user);
        return "redirect:/register?success=true";
    }

    @GetMapping("/register2")
    public String viewRegistrationForm(@RequestParam(value = "success", required = false) String success, Model model) {
        model.addAttribute("user", new User());
        if ("true".equals(success)) {
            model.addAttribute("message", "User added successfully");
        }
        return "admin-dashboard";
    }

    @PostMapping("/register2")
    public String addUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "admin-dashboard";
    }

}
