package com.example.AnakinSDE.controller;

import com.example.AnakinSDE.dto.UserDto;
import com.example.AnakinSDE.entity.JwtRequest;
import com.example.AnakinSDE.entity.JwtResponse;
import com.example.AnakinSDE.entity.User;
import com.example.AnakinSDE.security.JwtHelper;
import com.example.AnakinSDE.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private PasswordEncoder passwordEncoder; // Add this line

    @Autowired
    private UserServiceImpl userService;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);



//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
//
//        this.doAuthenticate(request.getUsername(), request.getPassword());
//
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        String token = this.helper.generateToken(userDetails);
//
//        JwtResponse response = JwtResponse.builder()
//                .JwtToken(token)
//                .username(userDetails.getUsername()).build();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        // Load user details from the database
        User user = userService.findByUsername(request.getUsername());

        // Check if user exists and password matches
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid Username or Password");
        }

        // Generate JWT token
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), Collections.emptyList());
        String token = helper.generateToken(userDetails);

        // Build response
        JwtResponse response = JwtResponse.builder()
                .JwtToken(token)
                .username(user.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        userService.register(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }


    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
