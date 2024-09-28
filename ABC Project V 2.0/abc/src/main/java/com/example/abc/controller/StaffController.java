package com.example.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

    @GetMapping("/staff-dashboard")
    public String viewStaffDashboard() {
        // Return the name of the HTML file (without the extension)
        return "staff-dashboard";
    }
}
