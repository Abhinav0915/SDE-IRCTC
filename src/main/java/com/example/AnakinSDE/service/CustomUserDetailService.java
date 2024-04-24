package com.example.AnakinSDE.service;

import com.example.AnakinSDE.entity.User;
import com.example.AnakinSDE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Loading Users From Database
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
