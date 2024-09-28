package com.example.abc.controller;

import com.example.abc.model.User;
import com.example.abc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            if ("Admin".equals(user.getUsertype())) {
                return "redirect:/admin";
            } else if ("Staff".equals(user.getUsertype())) {
                return "redirect:/staff-dashboard";
            } else {
                model.addAttribute("username", user.getUsername());
                return "redirect:/homepage"; // Redirect to user homepage
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Render the login page again with error message
    }
}
