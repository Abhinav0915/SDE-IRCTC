package com.example.AnakinSDE.controller;

import com.example.AnakinSDE.entity.User;
import com.example.AnakinSDE.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    // Autowired bean for user service implementation
    @Autowired
    private UserServiceImpl userService;

    // Logger for HomeController
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    // Endpoint to get list of users
    @GetMapping("/users")
    public List<User> getUser() {
        // Logging message for getting users
        System.out.println("Getting Users...");
        return userService.getUsers();
    }

    // Test endpoint
    @RequestMapping("/test")
    public String test() {
        // Logging warning message
        this.logger.warn("This is working message");
        return "Testing message";
    }


}