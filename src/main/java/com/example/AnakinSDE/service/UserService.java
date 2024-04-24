package com.example.AnakinSDE.service;

import com.example.AnakinSDE.dto.UserDto;
import com.example.AnakinSDE.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    void register(UserDto userDto);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User findByUsername(String username);
//    String login(LoginDto loginDto);
}

