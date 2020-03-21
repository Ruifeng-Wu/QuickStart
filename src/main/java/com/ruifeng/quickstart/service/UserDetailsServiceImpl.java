package com.ruifeng.quickstart.service;

import com.ruifeng.quickstart.dto.JwtInfoDto;
import com.ruifeng.quickstart.entity.User;
import com.ruifeng.quickstart.exception.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws NotFoundException {
        User user = userService.findUserByUserName(name);
        return new JwtInfoDto(user);
    }

}
